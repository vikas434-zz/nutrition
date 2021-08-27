package co.rivatech.nutrition.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.RationColor;
import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkLocation;
import lombok.Data;

/**
 * @author vranjan
 * created 22/08/2021
 */
@Data
public class Occupation {
    private Boolean havingRationCard;

    @JsonIgnore
    private RationColor rationCardColor;

    private Boolean havingAgriLand;

    private Boolean havingMnregaCard;

    private Boolean havingWork;

    private Boolean goingOutToWork;

    @JsonIgnore
    private WorkLocation workLocation;

    @JsonIgnore
    private WorkDuration workDuration;

    private Boolean SHGConnection;

    @JsonIgnore
    private MemberWorkingOut memberWorkingOut;
}
