package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.LMS;
import co.rivatech.nutrition.model.LMSEvaluation;
import co.rivatech.nutrition.model.LMSQnA;
import co.rivatech.nutrition.service.LMSService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/lms")
public class LMSResource {

    @Autowired
    private LMSService lmsService;


    @PostMapping("/add")
    @ApiOperation(value = "Add LMS details")
    public LMS addLMS(@Nonnull @RequestBody LMS lms) {
        return lmsService.addLMS(lms);
    }

    @GetMapping("/getLMS")
    @ApiOperation(value = "Currently it returns all the notices, later on we may need to divide based on district etc.")
    public List<LMS> getLMSData(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy) {
        return lmsService.getPaginatedLMS(pageNo, pageSize, sortBy);
    }

    @GetMapping("/getLMSEvaluationForUser/{userId}")
    @ApiOperation(value = "It returns lms evaluation details for a user id.")
    public List<LMSEvaluation> getLMSData(@PathVariable int userId) {
        return lmsService.getLmsEvaluationsForAUser(userId);
    }

    @PostMapping("/addLMSEvaluationForUser")
    @ApiOperation(value = "It adds lms evaluation for a user")
    public LMSEvaluation addLMSEvaluation(@RequestBody LMSEvaluation lmsEvaluation) {
        return lmsService.saveLmsEvaluation(lmsEvaluation);
    }

    @PostMapping("/addLMSQnA")
    @ApiOperation(value = "It adds lms Qustion and answer for a given LMS")
    public LMSQnA addLMSQnA(@RequestBody LMSQnA lmsQnA) {
        return lmsService.saveLmsQnA(lmsQnA);
    }

    @GetMapping("/getLMSQnAByLmsId/{lmsId}")
    @ApiOperation(value = "Gets list of all LMS qustion and answer to be used for evaluation.")
    public List<LMSQnA> getLmsQnAByLmsId(@PathVariable int lmsId) {
        return lmsService.geLMSQnAByLmsId(lmsId);
    }
}
