package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.RationColor;
import co.rivatech.nutrition.enums.RationColorHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class RationConfig {
    private List<RationColor> rationColors = Arrays.asList(RationColor.values());

    private List<String> rationColorsHindi = Arrays.stream(RationColorHindi.values())
                                            .map(RationColorHindi::valueOf)
                                            .collect(Collectors.toList());
}
