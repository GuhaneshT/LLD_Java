package BookmyShow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Interstellar");

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        Theatre theatre = new Theatre(1, "PVR", movies);
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.addTheatre(theatre);

        Show show = theatre.screens.get(0).shows.get(0);
        int seatNo = 2;

        System.out.println("Movie found: " + bookMyShow.browseByMovie("Inception").name);
        System.out.println("Fare for seat " + seatNo + ": " + show.getFareForSeat(seatNo));

        boolean locked = show.lockSeat(seatNo);
        System.out.println("Seat locked: " + locked);

        boolean booked = show.confirmSeatBooking(seatNo);
        System.out.println("Seat booked: " + booked);

        ShowSeat showSeat = show.getShowSeat(seatNo);
        System.out.println("Final seat status: " + showSeat.status);
    }
}
