package co.rivatech.nutrition.model;

import java.util.List;

import lombok.Data;

/**
 * @author vranjan
 * created 17/08/2021
 */
@Data
public class DistrictMaps {

    private List<District> districts;

    private List<Block> blocks;

    private List<Panchayat> panchayats;

    private List<Village> villages;
}
