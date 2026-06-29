package BookmyShow;

import java.util.List;
import java.util.ArrayList;

public class Show {
    public Screen screen;
    public List<ShowSeat> virtualSeats = new ArrayList<>();
    public String showID;
    public Movie streamedMovie;

    public Show(Screen screen,String showID, Movie streamedMovie){
        this.screen = screen;
        this.showID = showID;
        this.streamedMovie = streamedMovie;
        List<Seat> seats = screen.seats;

        for(Seat seat : seats){
            
            virtualSeats.add(new ShowSeat(seat,this,seat.type.getBasePrice()));
        }


    }

    public int getFareForSeat(int seatNo) {
        for (ShowSeat showSeat : virtualSeats) {
            if (showSeat.seat.seatNo == seatNo) {
                return showSeat.price;
            }
        }
        return -1;
    }

    public boolean lockSeat(int seatNo) {
        for (ShowSeat showSeat : virtualSeats) {
            if (showSeat.seat.seatNo == seatNo) {
                return showSeat.lock();
            }
        }
        return false;
    }

    public boolean confirmSeatBooking(int seatNo) {
        for (ShowSeat showSeat : virtualSeats) {
            if (showSeat.seat.seatNo == seatNo) {
                return showSeat.confirmBooking();
            }
        }
        return false;
    }

    public void releaseSeat(int seatNo) {
        for (ShowSeat showSeat : virtualSeats) {
            if (showSeat.seat.seatNo == seatNo) {
                showSeat.release();
                return;
            }
        }
    }

    public ShowSeat getShowSeat(int seatNo) {
        for (ShowSeat showSeat : virtualSeats) {
            if (showSeat.seat.seatNo == seatNo) {
                return showSeat;
            }
        }
        return null;
    }



    
    
}
