package movie;

import java.util.Comparator;

public class MovieTitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return first.getTitle().compareTo(second.getTitle());
    }
}
