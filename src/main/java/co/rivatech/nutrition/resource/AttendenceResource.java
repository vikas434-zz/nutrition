package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.DailyAttendence;
import co.rivatech.nutrition.service.AttendenceService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/attendence")
public class AttendenceResource {

    @Autowired
    private AttendenceService attendenceService;


    @PostMapping("/add")
    @ApiOperation(value = "Add a new attendance",
                  notes = "The attendance value will be uploaded on daily basis")
    public DailyAttendence addAttendance(@Nonnull @RequestBody DailyAttendence dailyAttendence) {
        return attendenceService.save(dailyAttendence);
    }

    @GetMapping("/getTodayAttendenceStatus")
    @ApiOperation(value = "Gets status for todays attendence",
                  notes = "This API can be useful to know, if the attendence" +
                          "is already submitted or not")
    public Boolean getTodaysAttendence() {
        return attendenceService.getTodaysAttendenceStatus();
    }

    @GetMapping("/getAttendenceList/{tolaId}")
    @ApiOperation(value = "Gets students details which are eligible for the attendence. Currently all data from tola id 1.TODO")
    public List<Child> getStudentData(@PathVariable int tolaId) {
        return attendenceService.getStudentData(tolaId);
    }

    @GetMapping("/getChildById/{id}")
    @ApiOperation(value = "Get child data by child id.")
    public Child getChildById(@PathVariable int id) {
        return attendenceService.getChildById(id);
    }

    @GetMapping("/getChildByName/{name}")
    @ApiOperation(value = "Get child data by child name.")
    public  List<Child> getChildByName(@PathVariable String name) {
        return attendenceService.getChildByName(name);
    }

    @GetMapping("/getChildByName/{nameHindi}")
    @ApiOperation(value = "Get child data by child name.")
    public  List<Child> getChildByNameHindi(@PathVariable String nameHindi) {
        return attendenceService.getChildByNameHindi(nameHindi);
    }
}
