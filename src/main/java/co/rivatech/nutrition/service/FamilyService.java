package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;

import co.rivatech.nutrition.enums.Entity;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.model.FamilyDetails;
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

    private static final String           SEPERATOR = "/";

    @Autowired
    private              FamilyRepository familyRepository;

    @Autowired
    private ShortNameMapRepository shortNameMapRepository;

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
        final int id = familyRepository.findTopByOrderByIdDesc().orElseGet(Family::new).getId();
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
}
