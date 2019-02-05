package books;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int pages;
    private double price;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    public int compareTo(Book book) {
        return getPages() - book.getPages();
    }

    @Override
    public String toString() {
        return String.format(
                "%s[%s, %s, %s, %s]", Book.class.getSimpleName(), getTitle(), getAuthor(), getPages(), getPrice()
        );
    }
}
