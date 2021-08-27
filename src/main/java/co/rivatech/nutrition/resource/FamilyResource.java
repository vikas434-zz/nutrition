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
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/getPaginatedFamilyData")
    @ApiOperation(value = "Get paginated family data by offset and limit")
    public List<Family> getPaginatedFamilyData(@RequestParam(defaultValue = "0") Integer pageNo,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        //TODO implement list
        return Arrays.asList(new Family());
    }

    @GetMapping("/getFamilyByFullFamilyId/{fullFamilyId}")
    @ApiOperation(value = "Find details about the family from family id e.g. KA-BO-CH-2")
    public Family getFamilyByFullFamilyId(@Nonnull @PathVariable String fullFamilyId) {
        //TODO family id
        return new Family();
    }

    @GetMapping("/getByFamilyHead/{familyHead}")
    @ApiOperation(value = "Find details about the family from family head name")
    public Family findByFamilyHead(@Nonnull @PathVariable String familyHead) {
        //TODO find by family Head
        return new Family();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds a family details",
                  notes = "Returns family data or throws exception")
    public Family addFamily(@Nonnull @RequestBody Family family) {
        return familyService.addFamily(family);
    }
}
