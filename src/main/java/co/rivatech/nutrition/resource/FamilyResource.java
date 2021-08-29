package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Collections;
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
    public Family getFamilyById(@Nonnull @PathVariable int familyId) {
        return familyService.getFamilyDetailsById(familyId);
    }

    @GetMapping("/getPaginatedFamilyData")
    @ApiOperation(value = "Get paginated family data by offset and limit")
    public List<Family> getPaginatedFamilyData(@RequestParam(defaultValue = "0") Integer pageNo,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam(defaultValue = "id") String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Family> pagedResult = familyService.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/getFamilyByFullFamilyId/{fullFamilyId}")
    @ApiOperation(value = "Find details about the family from family id e.g. KA-BO-CH-2")
    public Family getFamilyByFullFamilyId(@Nonnull @PathVariable String fullFamilyId) {
        return familyService.getFamilyDetailsByFullFamilyId(fullFamilyId);
    }

    @GetMapping("/getByFamilyHead/{familyHead}")
    @ApiOperation(value = "Find details about the family from family head name")
    public List<Family> findByFamilyHead(@Nonnull @PathVariable String familyHead) {
        return familyService.getFamilyDetailsByFamilyHead(familyHead);
    }

    @GetMapping("/getByFamilyHeadHindi/{familyHead}")
    @ApiOperation(value = "Find details about the family from family head name in Hindi, e.g राजपाल यादव")
    public List<Family> findByFamilyHeadHindi(@Nonnull @PathVariable String familyHead) {
        return familyService.getFamilyDetailsByFamilyHeadHindi(familyHead);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds a family details",
                  notes = "Returns family data or throws exception")
    public Family addFamily(@Nonnull @RequestBody Family family) {
        return familyService.addFamily(family);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Updates a family details",
                  notes = "Returns family data or throws exception")
    public Family updateFamily(@Nonnull @RequestBody Family family) {
        return familyService.updateFamily(family);
    }



    @DeleteMapping("/deleteById/{familyId}")
    @ApiOperation(value = "Delete family by id.",
                  notes = "Successfully deletes family data or throws exception")
    public ResponseEntity<?> deleteByFamilyId(@PathVariable int familyId) {
        familyService.deleteById(familyId);
        return ResponseEntity.ok().build();
    }
}
