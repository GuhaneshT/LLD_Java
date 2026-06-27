public abstract class Vehicle {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final String licenseNumber;
    private final Size size;
    private final VehicleType vehicleType;
    private final int hourlyRate;

    protected Vehicle(String licenseNumber, Size size, VehicleType vehicleType, int hourlyRate) {
        this.licenseNumber = licenseNumber;
        this.size = size;
        this.vehicleType = vehicleType;
        this.hourlyRate = hourlyRate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Size getSize() {
        return size;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int calculateFare(long parkedHours) {
        return (int) parkedHours * hourlyRate;
    }
}
