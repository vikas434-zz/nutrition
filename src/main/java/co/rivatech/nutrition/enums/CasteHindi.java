package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 02/09/2021
 */
public enum CasteHindi {
    GENERAL("सामान्य"),
    OBC("पिछड़ी जाति"),
    SC("अनुसूचित जाति"),
    ST("अनुसूचित जनजाति"),
    PVTG("आदिम जनजाति");

    private String hindiString;

    CasteHindi(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final CasteHindi casteHindi) {
        return casteHindi.hindiString;
    }
}
