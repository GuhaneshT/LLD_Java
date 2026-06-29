package BookmyShow;

import java.util.ArrayList;
import java.util.List;
public class Screen {
    public int screenID;
    public List<Show> shows = new ArrayList<>();
    public List<Seat> seats = new ArrayList<>();
    
    public Screen(int screenID,int regularSeats, int premiumSeats, int reclinerSeats, List<Movie> movies){
        this.screenID = screenID;
        int nextSeatNo = 1;
        for(int i = 0;i<regularSeats; i++){
            this.seats.add(new Seat(nextSeatNo++,this,SeatType.REGULAR));

        }
        for(int i = 0;i<premiumSeats; i++){
            this.seats.add(new Seat(nextSeatNo++,this,SeatType.PREMIUM));

        }
        for(int i = 0;i<reclinerSeats; i++){
            this.seats.add(new Seat(nextSeatNo++,this,SeatType.RECLINER));

        }
        
        int nextShowId = 1;
        for(Movie movie : movies){
            this.shows.add(new Show(this,screenID + "-" + nextShowId++,movie));
        }

   
   
    }

    
}
