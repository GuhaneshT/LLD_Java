package BookmyShow;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    public List<Theatre> theatres = new ArrayList<>();

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public Movie browseByMovie(String movieName) {
        for (Theatre theatre : theatres) {
            Movie movie = theatre.searchMovie(movieName);
            if (movie != null) {
                return movie;
            }
        }
        return null;
    }
}
