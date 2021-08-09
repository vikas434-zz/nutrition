package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.service.FamilyService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 07/08/2021
 */
@RestController
@RequestMapping("/v1/family")
public class FamilyResource {

    @Autowired
    private FamilyService familyService;

    public void checkMobileNumberExists() {

    };

    public void getFamilyById() {

    };

    public void getPaginatedFamilyData() {

    };

    @PostMapping("/add")
    @ApiOperation(value = "Adds a family details", notes = "Returns family data or throws exception")
    public Family addFamily(@Nonnull @RequestBody Family family) {
        return familyService.addFamily(family);
    }
}
