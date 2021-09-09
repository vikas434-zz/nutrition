package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.CasteHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 08/09/2021
 */
@Data
public class CasteConfig {
    private List<Caste> castes = Arrays.asList(Caste.values());

    private List<String> casteListHindi = Arrays.stream(CasteHindi.values())
                                                .map(CasteHindi::valueOf)
                                                .collect(Collectors.toList());
}
