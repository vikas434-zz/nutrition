package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum Vaccination {
    BCG("BCG"),
    HEPATITIS("Hepatitis"),
    OPV_AT_BIRTH("OPV - at birth"),
    OPV_6_WEEKS("OPV - 6 weeks"),
    OPV_10_WEEKS("OPV - 10 weeks"),
    OPV_14_WEEKS("OPV - 14 weeks"),
    IPV_POLIO("IPV(Polio)"),
    PENTAVALENT_6_WEEKS("Pentavalent - 6 weeks"),
    PENTAVALENT_10_WEEKS("Pentavalent - 10 weeks"),
    PENTAVALENT_14_WEEKS("Pentavalent - 14 weeks"),
    ROTAVIRUS_6_WEEKS("Rotavirus - 6 weeks"),
    ROTAVIRUS_10_WEEKS("Rotavirus - 10 weeks"),
    ROTAVIRUS_14_WEEKS("Rotavirus - 14 weeks"),
    MEASLES("Measles");

    private String hindiString;

    Vaccination(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final Vaccination vaccination) {
        return vaccination.hindiString;
    }

}
