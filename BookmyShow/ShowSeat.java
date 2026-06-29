package BookmyShow;

public class ShowSeat{
    public enum SeatStatus {
        AVAILABLE,
        LOCKED,
        BOOKED
    }

    public Seat seat;
    public Show show;
    public int price;
    public SeatStatus status;

    public ShowSeat(Seat seat , Show show, int price){
        this.seat = seat;
        this.show = show;    
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public boolean lock() {
        if (status != SeatStatus.AVAILABLE) {
            return false;
        }
        status = SeatStatus.LOCKED;
        return true;
    }

    public boolean confirmBooking() {
        if (status != SeatStatus.LOCKED) {
            return false;
        }
        status = SeatStatus.BOOKED;
        return true;
    }

    public void release() {
        if (status == SeatStatus.LOCKED) {
            status = SeatStatus.AVAILABLE;
        }
    }

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }
    
}
