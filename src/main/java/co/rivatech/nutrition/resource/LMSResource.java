package co.rivatech.nutrition.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.dto.LMSQnA;
import co.rivatech.nutrition.dto.UserScore;
import co.rivatech.nutrition.model.LMS;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/lms")
public class LMSResource {


    @PostMapping("/add")
    @ApiOperation(value = "[WIP] Add LMS details")
    public LMS addLMS(@Nonnull @RequestBody LMS lms) {
        //TODO add LMS data
        return null;
    }

    @GetMapping("/getLMS")
    @ApiOperation(value = "[WIP] Currently it returns all the notices, later on we may need to divide based on district etc.")
    public List<LMS> getLMSData(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy) {
        //TODO get LMS data
        return Collections.EMPTY_LIST;
    }

    @GetMapping("/getLMSQnAById/{id}")
    @ApiOperation(value = "[WIP] get LMS questions and answer by lms id")
    public LMSQnA getLMSQuestions(@PathVariable int id) {
        //TODO get LMS question
        return null;
    }

    @PutMapping("/upsertScore")
    @ApiOperation(value = "[WIP] Update score by user id")
    public UserScore upsertUserScore(@Nonnull @RequestBody UserScore userScore) {
        //TODO update user score.
        return null;
    }


}
