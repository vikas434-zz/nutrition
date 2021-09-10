package co.rivatech.nutrition.dto;

import java.util.List;

import co.rivatech.nutrition.model.Block;
import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.model.Panchayat;
import co.rivatech.nutrition.model.Tola;
import co.rivatech.nutrition.model.Village;
import lombok.Builder;
import lombok.Data;

/**
 * @author vranjan
 * created 17/08/2021
 */
@Data
@Builder
public class Configs {

    private CasteConfig casteConfig;

    private ReligionConfig religionConfig;

    private SexConfig sexConfig;

    private RationConfig rationConfig;

    private WorkLocationConfig workLocationConfig;

    private WorkDurationConfig workDurationConfig;

    private MemberWorkingOutConfig memberWorkingOutConfig;

    private List<District> districts;

    private List<Block> blocks;

    private List<Panchayat> panchayats;

    private List<Village> villages;

    private List<Tola> tolas;

}
