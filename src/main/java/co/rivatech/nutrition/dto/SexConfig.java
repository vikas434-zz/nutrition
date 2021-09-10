package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.Sex;
import co.rivatech.nutrition.enums.SexHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class SexConfig {
    private List<Sex> sexList = Arrays.asList(Sex.values());

    private List<String> sexListHindi = Arrays.stream(SexHindi.values())
                                              .map(SexHindi::valueOf)
                                              .collect(Collectors.toList());
}
