package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.dto.UploadImageResponse;
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

    private static final String S3_PREFIX = "https://vatsalya-photo.s3.ap-south-1.amazonaws.com";
    private static final String SEPERATOR = "/";


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

    @GetMapping("/getPhotosByTolaAndDate/{tolaId}/{type}/{dateYear}/{dateMonth}/{dateDay}")
    @ApiOperation(value = "Get photo by anganwadi id , type = BEFORE_MEAL/AFTER_MEAL, ")
    public String getListOfPhotosForBlock(@Nonnull @PathVariable int tolaId,
                                          @PathVariable String type,
                                          @PathVariable(name = "Year in yyyy, e.g. 2021") String dateYear,
                                          @PathVariable(name = "Month e.g. 06") String dateMonth,
                                          @PathVariable(name = "Date e.g. 06") String dateDay) {
        return S3_PREFIX + SEPERATOR + tolaId + SEPERATOR + type + SEPERATOR + dateYear + SEPERATOR + dateMonth + SEPERATOR + dateDay;
    }
}
