package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.repository.ChildRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public Child addChild(final Child child) {
        return childRepository.save(child);
    }
}
