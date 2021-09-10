package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.WorkLocation;
import co.rivatech.nutrition.enums.WorkLocationHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class WorkLocationConfig {
    private List<WorkLocation> workLocations = Arrays.asList(WorkLocation.values());

    private List<String> workLocationsHindi = Arrays.stream(WorkLocationHindi.values())
                                            .map(WorkLocationHindi::valueOf)
                                            .collect(Collectors.toList());
}
