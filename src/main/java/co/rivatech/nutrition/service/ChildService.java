package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.ChildDetails;
import co.rivatech.nutrition.repository.ChildDetailsRepository;
import co.rivatech.nutrition.repository.ChildRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ChildDetailsRepository childDetailsRepository;

    public Child addChild(final Child child) {
        return childRepository.save(child);
    }

    public void addAllChild(final List<Child> children) {
        childRepository.saveAll(children);
    }

    public List<Child> getChildByFamilyId(final int familyId) {
        final List<Child> children = childRepository.findByFamilyId(familyId);
        if (children.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No children details found for family id %s", familyId));
        }
        return children;
    }

    public ChildDetails addChildDetails(final ChildDetails childDetails) {
        return childDetailsRepository.save(childDetails);
    }
}
