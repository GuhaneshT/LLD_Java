import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingManager {
    private final ParkingLot parkingLot;
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.assignSpot(vehicle);
        if (spot == null) {
            throw new IllegalStateException("No parking spot available for " + vehicle.getVehicleType());
        }

        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot.getId(), LocalDateTime.now());
        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    public int unparkVehicle(String ticketId) {
        ParkingTicket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket id: " + ticketId);
        }

        ParkingSpot spot = parkingLot.getSpotById(ticket.getSpotId());
        if (spot == null || !spot.isOccupied()) {
            throw new IllegalStateException("Parking spot state is inconsistent for ticket " + ticketId);
        }

        spot.unpark();
        long parkedHours = Math.max(1, Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours());
        return ticket.getVehicle().calculateFare(parkedHours);
    }

    public int getAvailableSpots(VehicleType vehicleType) {
        return parkingLot.getAvailableSpots(vehicleType);
    }
}
