package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Woman;
import co.rivatech.nutrition.model.WomanDetails;
import co.rivatech.nutrition.repository.WomanDetailsRepository;
import co.rivatech.nutrition.repository.WomanRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class WomanService {

    @Autowired
    private WomanRepository womanRepository;

    @Autowired
    private WomanDetailsRepository womanDetailsRepository;

    public Woman addWoman(final Woman woman) {
        return womanRepository.save(woman);
    }

    public void addAllWomen(final List<Woman> women) {
        womanRepository.saveAll(women);
    }

    public List<Woman> getWomanByFamilyId(final int familyId) {
        final List<Woman> woman = womanRepository.findByFamilyId(familyId);
        if (woman.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No woman details found for family id %s", familyId));
        }
        return woman;
    }

    public WomanDetails addWomanDetails(final WomanDetails womanDetails) {
        return womanDetailsRepository.save(womanDetails);
    }

    public List<WomanDetails> getWomanDetailsByFamilyId(final int familyId){
        return womanDetailsRepository.findByFamilyId(familyId);
    }

}
