package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.LMS;
import co.rivatech.nutrition.model.LMSEvaluation;
import co.rivatech.nutrition.model.LMSQnA;
import co.rivatech.nutrition.repository.LMSEvaluationRepository;
import co.rivatech.nutrition.repository.LMSQnARepository;
import co.rivatech.nutrition.repository.LMSRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class LMSService {

    @Autowired
    private LMSRepository lmsRepository;

    @Autowired
    private LMSEvaluationRepository lmsEvaluationRepository;

    @Autowired
    private LMSQnARepository lmsQnARepository;

    public LMS addLMS(final LMS lms) {
        return lmsRepository.save(lms);
    }

    public List<LMS> getPaginatedLMS(final Integer pageNo, final Integer pageSize, final String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LMS> pagedResult = lmsRepository.findAll(paging);
        if (!pagedResult.isEmpty()) {
            return pagedResult.getContent();
        }
        else {
            return Collections.emptyList();
        }
    }

    public List<LMSEvaluation> getLmsEvaluationsForAUser(final int userId) {
        final List<LMSEvaluation> lmsEvaluations = lmsEvaluationRepository.findByUserId(userId);
        if (lmsEvaluations.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No LMS evaluation found for the user id %s", userId));
        }
        final int lmsId = lmsEvaluations.get(0).getLmsId();
        final LMS lms = lmsRepository.findById(lmsId)
                                     .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                             "No LMS found with the LMS id %s",
                                             lmsId)));
        lmsEvaluations.stream().forEach(l -> {
            l.setThumbnailUrl(lms.getThumbnailUrl());
            l.setTitle(lms.getTitle());
            l.setVideoUrl(lms.getVideoUrl());
        });
        return lmsEvaluations;
    }

    public LMSEvaluation saveLmsEvaluation(final LMSEvaluation lmsEvaluation) {
        return lmsEvaluationRepository.save(lmsEvaluation);
    }

    public LMSQnA saveLmsQnA(final LMSQnA lmsQnA) {
        return lmsQnARepository.save(lmsQnA);
    }

    public List<LMSQnA> geLMSQnAByLmsId(final int lmsId) {
        return lmsQnARepository.findByLmsId(lmsId);
    }
}
