package co.rivatech.nutrition.dto;

import java.util.List;

import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
public class LMSQnA {
    private int lmsId;

    private List<LMSAnswer> lmsAnswerList;
}
