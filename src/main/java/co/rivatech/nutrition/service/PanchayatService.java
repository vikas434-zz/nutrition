package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.Panchayat;
import co.rivatech.nutrition.repository.PanchayatRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class PanchayatService {

    @Autowired
    private PanchayatRepository panchayatRepository;


    public List<Panchayat> getAllPanchayats() {
        List<Panchayat> panchayats = new ArrayList<>();
        Iterable<Panchayat> items = panchayatRepository.findAll();
        items.forEach(panchayats::add);
        return panchayats;
    }

    public Panchayat addPanchayat(final Panchayat panchayat) {
        panchayatRepository.save(panchayat);
        return panchayat;
    }

    public Optional<Panchayat> getPanchayatById(final int panchayatId) {
        return panchayatRepository.findById(panchayatId);
    }

    public List<Panchayat> getPanchayatsByBlockId(final int districtId) {
        return panchayatRepository.findPanchayatByBlockId(districtId);
    }
}
