package numbers.enums;

public enum Properties {
    NULL("NULL"),
    BUZZ("BUZZ"),
    DUCK("DUCK"),
    PALINDROMIC("PALINDROMIC"),
    GAPFUL("GAPFUL"),
    SPY("SPY"),
    SQUARE("SQUARE"),
    SUNNY("SUNNY"),
    JUMPING("JUMPING"),
    HAPPY("HAPPY"),
    SAD("SAD"),
    EVEN("EVEN"),
    ODD("ODD"),
    EX_BUZZ("-BUZZ"),
    EX_DUCK("-DUCK"),
    EX_PALINDROMIC("-PALINDROMIC"),
    EX_GAPFUL("-GAPFUL"),
    EX_SPY("-SPY"),
    EX_SQUARE("-SQUARE"),
    EX_SUNNY("-SUNNY"),
    EX_JUMPING("-JUMPING"),
    EX_HAPPY("-HAPPY"),
    EX_SAD("-SAD"),
    EX_EVEN("-EVEN"),
    EX_ODD("-ODD")
    ;

    private final String s;
    Properties(String val) {
        s = val;
    }

    public String getValue() {
        return s;
    }
}
