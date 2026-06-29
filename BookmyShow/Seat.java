package BookmyShow;

public class Seat {
    public int seatNo;
    public Screen screen;
    public SeatType type;

    
    public Seat(int seatNo, Screen screen,SeatType type){
        
        this.seatNo = seatNo;
        this.screen = screen;
        this.type = type;
        
    }

    @Override
    public String toString() {
        return "Seat-" + seatNo + "(" + type + ")";
    }
    
}
