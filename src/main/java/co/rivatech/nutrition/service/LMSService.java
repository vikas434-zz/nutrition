package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import co.rivatech.nutrition.model.LMS;
import co.rivatech.nutrition.repository.LMSRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class LMSService {

    @Autowired
    private LMSRepository lmsRepository;


    public LMS addLMS(final LMS lms) {
        return lmsRepository.save(lms);
    }

    public List<LMS> getPaginatedLMS(final Integer pageNo, final Integer pageSize, final String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LMS> pagedResult = lmsRepository.findAll(paging);
        if(!pagedResult.isEmpty()) {
            return pagedResult.getContent();
        } else {
            return Collections.emptyList();
        }
    }
}
