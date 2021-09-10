package co.rivatech.nutrition.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.RationColor;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkLocation;
import lombok.Data;

/**
 * @author vranjan
 * created 08/09/2021
 */
@Data
public class ConfigSource {

    public static List<GeneralConfig> getCasteList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Caste.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), Caste.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getReligionList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Religion.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), Religion.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getSexList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Sex.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), Sex.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getRationColorList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(RationColor.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), RationColor.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workLocationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkLocation.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkLocation.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workDurationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkDuration.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkDuration.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MemberWorkingOutList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MemberWorkingOut.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), MemberWorkingOut.valueOf(c)));
        });
        return generalConfigs;
    }
}
