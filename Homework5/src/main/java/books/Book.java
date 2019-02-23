package books;

import com.sun.javafx.binding.StringFormatter;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int pages;
    private double price;

    public Book(String title, String author, int pages, double price){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }

    @Override
    public String toString() {
        return String.valueOf(StringFormatter.format(
                "[%s: %s, %i, %d]", this.title, this.author, this.pages, this.price
        ));
    }
}
