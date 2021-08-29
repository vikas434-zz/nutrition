package co.rivatech.nutrition.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.LocationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 *
 *
 */
@Data
@Entity(name = "notice")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "title")
    @ApiModelProperty(value = "title", required = true)
    private String title;

    @Column(name = "header")
    @ApiModelProperty(value = "header", required = true)
    private String header;

    @Column(name = "content")
    @ApiModelProperty(value = "content", notes = "in HTML formatted value", required = true)
    private String content;

    @Column(name = "image")
    @ApiModelProperty(value = "image", notes = "Uploaded image url or default image")
    private String image;

    @Type(type = "jsonb")
    @Column(name = "details_json", columnDefinition = "jsonb")
    @ApiModelProperty(value = "details_json",
                      required = true)
    private LocationData details;

    @Column(name = "created_at")
    @ApiModelProperty(value = "createdAt")
    private Date createdAt;

    @Column(name = "updated_at")
    @ApiModelProperty(value = "updatedAt")
    private Date updatedAt;
}
