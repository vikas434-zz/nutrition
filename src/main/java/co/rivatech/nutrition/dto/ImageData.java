package co.rivatech.nutrition.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
public class ImageData {
    private String title;

    private String description;

    private MultipartFile multipartFile;
}
