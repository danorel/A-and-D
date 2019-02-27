package movie;

import java.util.Comparator;

public class MovieProfitComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return (int)(first.getProfit() - second.getProfit());
    }
}
