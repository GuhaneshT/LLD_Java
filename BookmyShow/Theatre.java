package BookmyShow;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Theatre {
    public String name;
    public List<Screen> screens = new ArrayList<>();
    public List<Movie> movies = new ArrayList<>();
    public HashMap<Movie,Screen> movieMap = new HashMap<>();


    public Theatre(int noScreens,String name,List<Movie> movies){
        this.name = name;
        this.movies = movies;
        for(int i=0;i<noScreens;i++){
            
            screens.add(new Screen(i,1,1,1,movies));
        }
    
    }

    public Movie searchMovie(String movieName){
        for (Movie movie : movies){
            if (movie.name.equals(movieName)){
                return movie;
            }
        }
        return null;
    }



    
}
