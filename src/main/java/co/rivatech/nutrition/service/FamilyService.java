package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.Entity;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.dto.Configs;
import co.rivatech.nutrition.dto.DistrictMaps;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.dto.FamilyDetails;
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

    public Family addFamily(final Family family) {
        validateFamilyData(family);
        family.setFamilyId(getShortId(family.getDetails()));
        return familyRepository.save(family);
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
