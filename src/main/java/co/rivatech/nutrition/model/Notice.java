package co.rivatech.nutrition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "title")
    @ApiModelProperty(value = "title",
                      required = true)
    private String title;

    @Column(name = "header")
    @ApiModelProperty(value = "header",
                      required = true)
    private String header;

    @Column(name = "content")
    @ApiModelProperty(value = "content",
                      notes = "in HTML formatted value",
                      required = true)
    private String content;

    @Column(name = "image")
    @ApiModelProperty(value = "image",
                      notes = "Uploaded image url or default image")
    private String image;

    @Column(name = "created_at")
    @ApiModelProperty(value = "createdAt")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    @ApiModelProperty(value = "updatedAt")
    private Date updatedAt;

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;

    @ApiModelProperty(value = "districtId",
                      required = true)
    @Column(name = "district_id")
    private int districtId;

    @ApiModelProperty(value = "blockId",
                      required = true)
    @Column(name = "block_id")
    private int blockId;

    @ApiModelProperty(value = "panchayatId",
                      required = true)
    @Column(name = "panchayat_id")
    private int panchayatId;

    @ApiModelProperty(value = "villageId",
                      required = true)
    @Column(name = "village_id")
    private int villageId;
}
