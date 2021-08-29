package co.rivatech.nutrition.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
public class LocationData {
    @ApiModelProperty(value = "districtId",
                      required = true)
    private int districtId;

    @ApiModelProperty(value = "blockId",
                      required = true)
    private int blockId;

    @ApiModelProperty(value = "panchayatId",
                      required = true)
    private int panchayatId;

    @ApiModelProperty(value = "villageId",
                      required = true)
    private int villageId;
}
