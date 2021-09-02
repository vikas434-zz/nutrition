package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum MemberWorkingOutHindi {
    ADULT_MALE("सिर्फ वयस्क पुरुष"),
    ALL_ADULTS("सिर्फ वयस्क सदस्य"),
    ALL_MEMBERS("सभी सदस्य");

    private String hindiString;

    MemberWorkingOutHindi(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final MemberWorkingOutHindi memberWorkingOutHindi) {
        return memberWorkingOutHindi.hindiString;
    }
}
