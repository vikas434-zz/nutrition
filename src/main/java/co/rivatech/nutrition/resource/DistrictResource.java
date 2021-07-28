package co.rivatech.nutrition.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.model.District;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 28/07/2021
 */
@RestController
@RequestMapping("/v1/district")
public class DistrictResource {

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the district")
    public List<District> getAllDistrict() {
        return new ArrayList<>();
    }

}
