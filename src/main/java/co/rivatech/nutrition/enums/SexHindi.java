package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 09/08/2021
 */
public enum SexHindi {
    MALE("पुरुष"),
    FEMALE("स्त्री");

    private String hindiString;

    SexHindi(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final SexHindi sexHindi) {
        return sexHindi.hindiString;
    }
}
