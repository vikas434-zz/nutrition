package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.dto.UploadImageResponse;
import co.rivatech.nutrition.enums.MEALTYPE;
import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.service.AWSS3Service;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/photo")
public class PhotoResource {

    @Autowired
    private AWSS3Service awss3Service;

    @PostMapping("/beforeMeal")
    @ApiOperation(value = "Upload photo before meal.",
                  notes = "Upload today's photo. Also, please pass the tola Id.")
    public UploadImageResponse uploadPhotoBeforeMeal(@RequestParam(value = "file") MultipartFile file,
                                                     @RequestParam(value = "tolaId") int tolaId) {
        return awss3Service.uploadFile(file, tolaId, MEALTYPE.BEFORE_MEAL);
    }

    @PostMapping("/duringMeal")
    @ApiOperation(value = "Upload photo before meal.",
                  notes = "Upload today's photo. Also, please pass the tola Id.")
    public UploadImageResponse uploadPhotoAfterMeal(@RequestParam(value = "file") MultipartFile file,
                                                    @RequestParam(value = "tolaId") int tolaId) {
        return awss3Service.uploadFile(file, tolaId, MEALTYPE.AFTER_MEAL);
    }

    @GetMapping("/getPhotosByBlock/{blockId}")
    @ApiOperation(value = "[WORK IN PROGRESS] Get all photos, tied to that block. ")
    public List<String> getListOfPhotosForBlock(@Nonnull @PathVariable int blockId) {
        return Collections.emptyList();
    }
}
