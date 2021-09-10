package co.rivatech.nutrition.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.rivatech.nutrition.enums.CasteHindi;
import co.rivatech.nutrition.enums.MemberWorkingOutHindi;
import co.rivatech.nutrition.enums.RationColorHindi;
import co.rivatech.nutrition.enums.ReligionHindi;
import co.rivatech.nutrition.enums.SexHindi;
import co.rivatech.nutrition.enums.WorkDurationHindi;
import co.rivatech.nutrition.enums.WorkLocationHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 08/09/2021
 */
@Data
public class ConfigSource {

    public static List<GeneralConfig> getCasteList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(CasteHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), CasteHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getReligionList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(ReligionHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), ReligionHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getSexList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(SexHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), SexHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getRationColorList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(RationColorHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), RationColorHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workLocationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkLocationHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkLocationHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workDurationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkDurationHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkDurationHindi.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MemberWorkingOutList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MemberWorkingOutHindi.values()).forEach(c-> {
            generalConfigs.add(new GeneralConfig(c.name(), MemberWorkingOutHindi.valueOf(c)));
        });
        return generalConfigs;
    }
}
