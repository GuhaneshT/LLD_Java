package ParkingLot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingLot(int bikes, int cars, int trucks) {
        addSpots("B", bikes, VehicleType.BIKE);
        addSpots("C", cars, VehicleType.CAR);
        addSpots("T", trucks, VehicleType.TRUCK);
    }

    private void addSpots(String prefix, int count, VehicleType type) {
        for (int i = 1; i <= count; i++) {
            parkingSpots.add(new ParkingSpot(prefix + i, type));
        }
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.park(vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot getSpotById(String spotId) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getId().equals(spotId)) {
                return spot;
            }
        }
        return null;
    }

    public int getAvailableSpots(VehicleType vehicleType) {
        int available = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSupportedType() == vehicleType && !spot.isOccupied()) {
                available++;
            }
        }
        return available;
    }

    public List<ParkingSpot> getParkingSpots() {
        return Collections.unmodifiableList(parkingSpots);
    }
}
