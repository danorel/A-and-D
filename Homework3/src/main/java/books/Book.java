package books;

public class Book implements Comparable<Book> {
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

    @Override
    public String toString() {
        return String.format(
                "%s[%s, %s, %s, %s]", getClass().getSimpleName(), getTitle(), getAuthor(), getPages(), getPrice()
        );
    }

    public int compareTo(Book book) {
        return getTitle().compareTo(book.getTitle());
    }
}
