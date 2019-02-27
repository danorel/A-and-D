package movie;

import java.util.Comparator;

public class MovieDurationComparator implements Comparator <Movie>{
    @Override
    public int compare(Movie first, Movie second) {
        return (int)(first.getDuration() - second.getDuration());
    }
}
