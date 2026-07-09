package Splitwise;

public enum SplitType {
    EQUAL,
    EXACT,
    PERCENTAGE;

    public static SplitType from(SplitStrategies strategy) {
        return switch (strategy) {
            case EQUAL -> EQUAL;
            case EXACT -> EXACT;
            case PERCENTAGE -> PERCENTAGE;
        };
    }
}
