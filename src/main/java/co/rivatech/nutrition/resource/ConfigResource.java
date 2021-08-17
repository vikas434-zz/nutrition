package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.rivatech.nutrition.model.Configs;
import co.rivatech.nutrition.service.FamilyService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 07/08/2021
 */
@RestController
@RequestMapping("/v1/config")
public class ConfigResource {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/allConfig")
    @ApiOperation(value = "Gets the list of enums like caste, religion etc.")
    public Configs getAllConfig() {
        return familyService.getAllConfigs();
    }
}
