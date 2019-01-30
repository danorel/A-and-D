public class Album implements Comparable<Album>{
    private double price;
    private String title;
    private String director;

    public String getDirector() {
        return director;
    }

    public Album setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Album setTitle(String title) {
        this.title = title;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Album setPrice(double price) {
        this.price = price;
        return this;
    }

    public int compareTo(Album album) {
        return (int) (this.price - album.price);
    }

    @Override
    public String toString() {
        return Double.toString(price);
    }
}
