package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.service.ChildService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 18/08/2021
 */
@RestController
@RequestMapping("/v1/child")
public class ChildResource {

    @Autowired
    private ChildService childService;

    @PostMapping("/add")
    @ApiOperation(value = "Adds a child details to the family")
    public Child addChild(@Nonnull @RequestBody Child child) {
        return childService.addChild(child);
    }

    @GetMapping("/getByFullFamilyId/{familyId}")
    @ApiOperation(value = "Gets details of the child by full familyId, e.g. ")
    public void getChildByFullFamilyId(@Nonnull @PathVariable String familyId) {

    }
}
