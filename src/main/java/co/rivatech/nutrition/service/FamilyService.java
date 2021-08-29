package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import co.rivatech.nutrition.dto.Children;
import co.rivatech.nutrition.dto.Configs;
import co.rivatech.nutrition.dto.DistrictMaps;
import co.rivatech.nutrition.dto.FamilyDetails;
import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.Entity;
import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkLocation;
import co.rivatech.nutrition.exception.MobileAlreadyExistsException;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.repository.FamilyRepository;
import co.rivatech.nutrition.repository.ShortNameMapRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Slf4j
@Service
public class FamilyService {

    private static final String SEPERATOR = "-";

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ShortNameMapRepository shortNameMapRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private PanchayatService panchayatService;

    @Autowired
    private VillageService villageService;

    @Autowired
    private TolaService tolaService;

    @Autowired
    private ChildService childService;

    public Family addFamily(final Family family) {
        validateFamilyData(family);
        family.setFamilyId(getShortId(family.getDetails()));

        //TODO save other details to other tables, including women and children.
        final Family savedData =  familyRepository.save(family);
        saveOtherDetailsAsync(savedData.getDetails(), savedData.getId());
        return savedData;
    }

    @Async
    protected void saveOtherDetailsAsync(final FamilyDetails details, final int familyId) {
        final List<Children> childrenList = details.getChildrenList();
        if (!CollectionUtils.isEmpty(childrenList)) {
            final List<Child> children = new ArrayList<>();
            childrenList.forEach(c -> {
                final Child child = new Child();
                child.setFamilyId(familyId);
                child.setName(c.getName());
                child.setNameHindi(c.getNameHindi());
                children.add(child);
            });
            childService.addAllChild(children);
        }

//        if (!CollectionUtils.isEmpty(details.getWomenList())) {
//            womenService.save(details.getChildrenList(), familyId);
//        }
//
//        if (Objects.nonNull(details.getLocation())) {
//            locationService.save(details.getLocation(), familyId);
//        }
//
//        if (Objects.nonNull(details.getOccupation())) {
//            occupationService.save(details.getOccupation(), familyId);
//        }
//
//        if (Objects.nonNull(details.getFinance())) {
//            financialService.save(details.getFinance(), familyId);
//        }

    }

    private String getShortId(final FamilyDetails details) {
        final Map<Entity, Map<Integer, String>> shortMap = shortNameMapRepository.getShortNameMap();
        final String district = shortMap.get(Entity.DISTRICT).get(details.getDistrictId());
        final String block = shortMap.get(Entity.BLOCK).get(details.getBlockId());
        final String panchayat = shortMap.get(Entity.PANCHAYAT).get(details.getPanchayatId());
        final String village = shortMap.get(Entity.VILLAGE).get(details.getVillageId());
        final int id = familyRepository.findTopByOrderByIdDesc().orElseGet(Family::new).getId() + 1;
        log.info("District {} Block {} Panchayat {} Village {} and Id {}", district, block, panchayat, village, id);
        return district +
                SEPERATOR +
                block +
                SEPERATOR +
                panchayat +
                SEPERATOR +
                village +
                SEPERATOR +
                id;
    }

    private void validateFamilyData(final Family family) { //NOPMD
        final BigInteger mobile = family.getMobile();
        if (familyRepository.findByMobile(mobile).isPresent()) {
            throw new MobileAlreadyExistsException(String.format("Mobile entry exists with this number %s", mobile));
        }
        Assert.notNull(family.getDetails(), "Family details not shared.");
        Assert.isTrue(family.getDetails().getTotalMembers() >= family.getDetails()
                                                                     .getTotalChildren() + family.getDetails()
                                                                                                 .getTotalWomen(),
                      "Total family size mismatch.");
    }

    public Family checkMobileNumber(final BigInteger mobile) {
        return familyRepository.findByMobile(mobile)
                               .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                       "No Family details found with mobile %s ",
                                       mobile)));
    }

    public Family getFamilyDetailsByFamilyId(final String familyId) {
        return familyRepository.findByFamilyId(familyId)
                               .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                       "No Family details found with familyId %s ",
                                       familyId)));

    }

    public Configs getAllConfigs() {
        return Configs.builder()
                      .casteList(Arrays.asList(Caste.values()))
                      .religionList(Arrays.asList(Religion.values()))
                      .sexList(Arrays.asList(
                              Sex.values()))
                      .workLocations(Arrays.asList(WorkLocation.values()))
                      .workDurations(Arrays.asList(WorkDuration.values()))
                      .memberWorkingOutList(Arrays.asList(MemberWorkingOut.values()))
                      .districts(districtService.getAllDistricts())
                      .blocks(blockService.getAllBlocks())
                      .panchayats(panchayatService.getAllPanchayats())
                      .villages(villageService.getAllVillages())
                      .tolas(tolaService.getAllTola())
                      .build();
    }

    public DistrictMaps getAllDistrictData() {
        final DistrictMaps maps = new DistrictMaps();
        maps.setDistricts(districtService.getAllDistricts());
        maps.setBlocks(blockService.getAllBlocks());
        maps.setPanchayats(panchayatService.getAllPanchayats());
        maps.setVillages(villageService.getAllVillages());
        maps.setTolas(tolaService.getAllTola());
        return maps;
    }

}
