package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
    public int compare(Book firstBook, Book secondBook) {
        return (int) (firstBook.getPrice() - secondBook.getPrice());
    }
}
