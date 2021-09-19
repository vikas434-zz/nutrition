package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.rivatech.nutrition.enums.MEALTYPE;
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
                  notes = "Upload today's photo. Also, please give full name of the path" +
                          " e.g. bokaro-bermo-lalganj-kamleshpur-khunti, i.e. from district to tola")
    public String uploadPhotoBeforeMeal(@RequestParam(value = "file") MultipartFile file,
                                        @RequestParam(value = "path") String path) {
        return awss3Service.uploadFile(file, path, MEALTYPE.BEFORE_MEAL);
    }

    @PostMapping("/duringMeal")
    @ApiOperation(value = "Upload photo before meal.",
                  notes = "Upload today's photo. Also, please give full name of the path" +
                          " e.g. bokaro-bermo-lalganj-kamleshpur-khunti, i.e. from district to tola")
    public String uploadPhotoAfterMeal(@RequestParam(value = "file") MultipartFile file,
                                       @RequestParam(value = "path") String path) {
        return awss3Service.uploadFile(file, path, MEALTYPE.AFTER_MEAL);
    }
}
