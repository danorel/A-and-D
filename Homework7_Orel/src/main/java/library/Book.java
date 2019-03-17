package library;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private double price;
    private double rate;

    public Book(String title, String author, double price, double rate){
        this.title = title;
        this.author = author;
        this.price = price;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
