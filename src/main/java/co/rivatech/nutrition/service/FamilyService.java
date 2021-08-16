package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.repository.FamilyRepository;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public Family addFamily(final Family family) {
        validateFamilyData(family);

        return familyRepository.save(family);
    }

    private void validateFamilyData(final Family family) { //NOPMD
        Assert.notNull(family.getDetails(), "Family details not shared.");
        Assert.isTrue(family.getDetails().getTotalMembers() >= family.getDetails()
                                                                     .getTotalChildren() + family.getDetails()
                                                                                                 .getTotalWomen(),
                      "Total family size mismatch.");
    }
}
