package ParkingLot;
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2, 2, 1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);

        ParkingTicket bikeTicket = parkingManager.parkVehicle(new Bike("BIKE-101"));
        ParkingTicket carTicket = parkingManager.parkVehicle(new Car("CAR-201"));

        System.out.println("Bike parked at spot: " + bikeTicket.getSpotId());
        System.out.println("Car parked at spot: " + carTicket.getSpotId());
        System.out.println("Available car spots: " + parkingManager.getAvailableSpots(VehicleType.CAR));

        int bikeFare = parkingManager.unparkVehicle(bikeTicket.getTicketId());
        System.out.println("Bike fare: " + bikeFare);
    }
}
