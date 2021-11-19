package co.rivatech.nutrition.model;

import java.math.BigInteger;
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
 * created 07/08/2021
 *
 * CREATE TABLE users (
 *     id SERIAL PRIMARY KEY,
 *     email character varying,
 *     mobile bigint,
 *     created_at date DEFAULT CURRENT_DATE,
 *     updated_at date DEFAULT CURRENT_DATE,
 *     name character varying,
 *     name_hi character varying
 * );
 */
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "User Id")
    private int id;

    @Column(name = "email")
    @ApiModelProperty(value = "Email id of the user",
                      required = false)
    private String email;

    @ApiModelProperty(value = "mobile the user",
                      required = true)
    @Column(name = "mobile")
    private BigInteger mobile;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    private Date updatedAt;

    @ApiModelProperty(value = "Name of the user",
                      required = true)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "Name of the user in hindi",
                      required = true)
    @Column(name = "name_hi")
    private String nameHindi;

    @ApiModelProperty(value = "ROLE_SUPER_ADMIN,\n" +
            "    ROLE_DISTRICT,\n" +
            "    ROLE_BLOCK,\n" +
            "    ROLE_ANGANWADI,\n" +
            "    ROLE_SURVEYOR",
                      required = true)
    @Column(name = "role")
    private String role;

    @ApiModelProperty(value = "Id of the district/block attached to. Please pass block/village/tola id associated." +
            "if the user is superadmin, please pass 0",
                      required = true)
    @Column(name = "resource_id")
    private String resourceId;

}
