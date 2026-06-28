package ParkingLot;
public class Bike extends Vehicle {
    public Bike(String licenseNumber) {
        super(licenseNumber, Size.SMALL, VehicleType.BIKE, 10);
    }
}
