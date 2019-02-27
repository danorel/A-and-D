package movie;

import com.sun.javafx.binding.StringFormatter;

public class Movie implements Comparable<Movie>{
    private String title;
    private String director;
    private double duration;
    private double profit;

    public Movie(String title, String director, double duration, double price){
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.profit = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public double getDuration() {
        return duration;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return StringFormatter.format(
                "%s[%s, %s, %s]", getTitle(), getDirector(), getDuration(), getProfit()
        ).toString();
    }

    @Override
    public int compareTo(Movie album) {
        return getTitle().compareTo(album.getTitle());
    }
}