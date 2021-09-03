package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum RationColorHindi {
    PINK("गुलाबी"),
    YELLOW("पीला"),
    WHITE("उजला"),
    GREEN("हरा");

    private String hindiString;

    RationColorHindi(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final RationColorHindi rationColorHindi) {
        return rationColorHindi.hindiString;
    }
}
