public class ParkingSpot {
    private final String id;
    private final VehicleType supportedType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id, VehicleType supportedType) {
        this.id = id;
        this.supportedType = supportedType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getSupportedType() {
        return supportedType;
    }

    public boolean isOccupied() {
        return parkedVehicle != null;
    }

    public boolean canPark(Vehicle vehicle) {
        return !isOccupied() && vehicle.getVehicleType() == supportedType;
    }

    public boolean park(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            return false;
        }
        parkedVehicle = vehicle;
        return true;
    }

    public Vehicle unpark() {
        Vehicle vehicle = parkedVehicle;
        parkedVehicle = null;
        return vehicle;
    }
}
