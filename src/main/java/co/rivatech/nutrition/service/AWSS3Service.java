package co.rivatech.nutrition.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import co.rivatech.nutrition.dto.UploadImageResponse;
import co.rivatech.nutrition.enums.MEALTYPE;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vranjan
 * created 19/09/2021
 */
@Service
@Slf4j
public class AWSS3Service {
    private static final String            DIV     = "/";
    private static final DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("uuuu/MM/dd");

    @Value("${app.awsServices.bucketName}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public UploadImageResponse uploadFile(final MultipartFile file, int tolaId, MEALTYPE mealtype) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = dtfDate.format(LocalDate.ofInstant(Instant.now(),
                                                             ZoneId.systemDefault())) + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName + DIV + tolaId + DIV + mealtype, fileName, fileObj));
        fileObj.delete();
        return new UploadImageResponse(fileName, tolaId, mealtype);
    }

    private File convertMultiPartFileToFile(final MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

}
