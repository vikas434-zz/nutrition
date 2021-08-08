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

import co.rivatech.nutrition.model.Village;
import co.rivatech.nutrition.service.VillageService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/village")
public class VillageResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private VillageService villageService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the villages.")
    public List<Village> getAllPanchayats() {
       return villageService.getAllVillages();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a village.")
    public ResponseEntity<Village> addDistrict(@Nonnull @RequestBody Village village) {
        return ResponseEntity.ok(villageService.addVillage(village));
    }

}
