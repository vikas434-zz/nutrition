package co.rivatech.nutrition.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.DailyAttendence;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/attendence")
public class AttendenceResource {

    @PostMapping("/add")
    @ApiOperation(value = "[WIP] Add a new attendance", notes = "The attendance value will be uploaded on daily basis")
    public List<DailyAttendence> addAttendance(@Nonnull @RequestBody DailyAttendence dailyAttendence) {
        //TODO add attendence
        return Collections.emptyList();
    }

    @GetMapping("/getTodayAttendenceStatus")
    @ApiOperation(value = "[WIP] Gets status for todays attendence", notes = "This API can be useful to know, if the attendence" +
            "is already submitted or not")
    public Boolean getTodaysAttendence() {
        //TODO get attendence
        return false;
    }
}
