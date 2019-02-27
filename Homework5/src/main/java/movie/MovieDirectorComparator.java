package movie;

import java.util.Comparator;

public class MovieDirectorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return first.getDirector().compareTo(second.getDirector());
    }
}
