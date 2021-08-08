package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.repository.DistrictRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;


    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        Iterable<District> items = districtRepository.findAll();
        items.forEach(districts::add);
        return districts;
    }

    public District addDistrict(final District district) {
        districtRepository.save(district);
        return district;
    }

    public Optional<District> getDistrictById(final int districtId) {
        return districtRepository.findById(districtId);
    }
}
