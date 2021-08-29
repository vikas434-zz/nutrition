package co.rivatech.nutrition.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.dto.ImageData;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/photo")
public class PhotoResource {

    @PostMapping("/beforeMeal")
    @ApiOperation(value = "[WIP] Upload photo before meal.", notes = "Upload todays photo only. No option to edit")
    public boolean uploadPhotoBeforeMeal(@Nonnull @RequestBody ImageData data) {
        return false;
    }

    @PostMapping("/duringMeal")
    @ApiOperation(value = "[WIP] Upload photo during meal.", notes = "Upload todays photo only. No option to edit")
    public boolean uploadPhotoAfterMeal(@Nonnull @RequestBody ImageData data) {
        return false;
    }
}
