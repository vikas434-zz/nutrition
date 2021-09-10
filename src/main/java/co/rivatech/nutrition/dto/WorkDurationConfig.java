package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkDurationHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class WorkDurationConfig {
    private List<WorkDuration> workDurations = Arrays.asList(WorkDuration.values());

    private List<String> workDurationsHindi = Arrays.stream(WorkDurationHindi.values())
                                                    .map(WorkDurationHindi::valueOf)
                                                    .collect(Collectors.toList());
}
