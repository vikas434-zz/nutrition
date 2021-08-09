package co.rivatech.nutrition.model;

import java.io.Serializable;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import lombok.Data;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Data
public class FamilyDetails implements Serializable {

    private Sex sex;

    private Caste caste;

    private Religion religion;

    private String otherReligion;

    private int totalMembers;

    private int totalChildren;

    private int totalWomen;

    private int mamChild;

    private int anaemicWomen;

}
