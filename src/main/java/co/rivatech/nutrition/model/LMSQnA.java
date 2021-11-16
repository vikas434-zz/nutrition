package co.rivatech.nutrition.model;

import org.hibernate.annotations.Type;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.Options;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
@Entity(name = "lms_qna")
public class LMSQnA {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "lms_id")
    @ApiModelProperty(value = "lms id",
                      required = true)
    private int lmsId;

    @Column(name = "question_no")
    @ApiModelProperty(value = "Question no.",
                      required = true)
    private int questionNo;

    @Column(name = "question_title")
    @ApiModelProperty(value = "Question title",
                      required = true)
    private String questionTitle;

    @Type(type = "jsonb")
    @Column(name = "options",
            columnDefinition = "jsonb")
    @ApiModelProperty(value = "options for the question",
                      required = true)
    private Options options;

    @Column(name = "right_option")
    @ApiModelProperty(value = "Right option for the question",
                      required = true)
    private int rightOption;

    @Column(name = "marks")
    @ApiModelProperty(value = "maximum marks of the question",
                      required = true)
    private int marks;

    @Column(name = "created_at")
    private Date createdAt = new Date();
}
