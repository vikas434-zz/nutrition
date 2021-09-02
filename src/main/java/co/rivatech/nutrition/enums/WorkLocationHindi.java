package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum WorkLocationHindi {
    OTHER_PART_OF_DISTRICT("जिला के दूसरे हिस्से में"),
    OTHER_PART_OF_STATE("राज्य के दूसरे हिस्से में "),
    OTHER_STATE("दूसरे राज्य में");

    private String hindiString;

    WorkLocationHindi(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final WorkLocationHindi workLocationHindi) {
        return workLocationHindi.hindiString;
    }
}
