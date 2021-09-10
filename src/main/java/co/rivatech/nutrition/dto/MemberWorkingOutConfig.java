package co.rivatech.nutrition.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.MemberWorkingOutHindi;
import lombok.Data;

/**
 * @author vranjan
 * created 10/09/2021
 */
@Data
public class MemberWorkingOutConfig {
    private List<MemberWorkingOut> memberWorkingOuts = Arrays.asList(MemberWorkingOut.values());

    private List<String> memberWorkingOutsHindi = Arrays.stream(MemberWorkingOutHindi.values())
                                                        .map(MemberWorkingOutHindi::valueOf)
                                                        .collect(Collectors.toList());
}
