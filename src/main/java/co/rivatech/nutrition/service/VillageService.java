package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.model.Village;
import co.rivatech.nutrition.repository.VillageRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;


    public List<Village> getAllVillages() {
        List<Village> panchayats = new ArrayList<>();
        Iterable<Village> items = villageRepository.findAll();
        items.forEach(panchayats::add);
        return panchayats;
    }

    public Village addVillage(final Village village) {
        villageRepository.save(village);
        return village;
    }

    public List<Village> getAllVillagesByPanchayatId(final int panchayatId) {
        return villageRepository.findVillageByPanchayatId(panchayatId);
    }
}
