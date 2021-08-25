package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

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

    @GetMapping("/checkMobile/{mobile}")
    @ApiOperation(value = "Checks if mobile number exists or throws exception")
    public Family checkMobileNumberExists(@Nonnull @PathVariable BigInteger mobile) {
        return familyService.checkMobileNumber(mobile);
    }

    @GetMapping("/getByFamilyId/{familyId}")
    @ApiOperation(value = "Get family details by family id")
    public Family getFamilyById(@Nonnull @PathVariable String familyId) {
        return familyService.getFamilyDetailsByFamilyId(familyId);
    }

    //TODO
    public void getPaginatedFamilyData() {

    }

    @GetMapping("/findByMobile/{mobile}")
    @ApiOperation(value = "Returns family details by mobile number or else throw 404.")
    public Family findByMobile(@RequestParam BigInteger mobile) {
        return familyService.findByMobileNumber(mobile);
    }

    //TODO
    public void findByFamilyHead() {

    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds a family details",
                  notes = "Returns family data or throws exception")
    public Family addFamily(@Nonnull @RequestBody Family family) {
        return familyService.addFamily(family);
    }
}
