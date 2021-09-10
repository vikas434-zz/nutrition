package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.ReligionHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class ReligionConfig {
    private List<Religion> religions = Arrays.asList(Religion.values());

    private List<String> religionHindi = Arrays.stream(ReligionHindi.values())
                                            .map(ReligionHindi::valueOf)
                                            .collect(Collectors.toList());
}
