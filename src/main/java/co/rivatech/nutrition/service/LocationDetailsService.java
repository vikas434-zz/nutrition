package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.rivatech.nutrition.exception.ResourceAlreadyExistsException;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.LocationDetails;
import co.rivatech.nutrition.repository.LocationDetailsRepository;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Service
public class LocationDetailsService {
    @Autowired
    private LocationDetailsRepository locationDetailsRepository;

    public LocationDetails getLocationByFamilyId(final int familyId) {
        return locationDetailsRepository.findByFamilyId(familyId)
                                        .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                                "No location details found for familyId %s",
                                                familyId)));
    }

    public LocationDetails save(final LocationDetails locationDetails) {
        final int familyId = locationDetails.getFamilyId();
        if(locationDetailsRepository.findByFamilyId(familyId).isPresent()) {
            throw new ResourceAlreadyExistsException(String.format("Location details already present for family id %s", familyId));
        }
        return locationDetailsRepository.save(locationDetails);
    }
}
