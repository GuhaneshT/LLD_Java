// SeatType.java
package BookmyShow;

public enum SeatType {
    REGULAR(150),
    PREMIUM(250),
    RECLINER(400);

    private final int basePrice;

    SeatType(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
