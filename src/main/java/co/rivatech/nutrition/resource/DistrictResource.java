package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.service.DistrictService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 28/07/2021
 */
@RestController
@RequestMapping("/v1/district")
public class DistrictResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private DistrictService districtService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the district")
    public List<District> getAllDistrict() {
       return districtService.getAllDistricts();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a district")
    public ResponseEntity<District> addDistrict(@Nonnull @RequestBody District district) {
        return ResponseEntity.ok(districtService.addDistrict(district));
    }

}
