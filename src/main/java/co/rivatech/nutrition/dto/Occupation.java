package co.rivatech.nutrition.dto;

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

    private RationColor rationCardColor;

    private Boolean havingAgriLand;

    private Boolean havingMnregaCard;

    private Boolean havingWork;

    private Boolean goingOutToWork;

    private WorkLocation workLocation;

    private WorkDuration workDuration;

    private Boolean SHGConnection;

    private MemberWorkingOut memberWorkingOut;
}
