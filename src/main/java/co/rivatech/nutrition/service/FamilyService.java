package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // add option for autogeneration of family id.
        return familyRepository.save(family);
    }

    //TODO validate and throw exceptions if any.
    private void validateFamilyData(final Family family) { //NOPMD

    }
}
