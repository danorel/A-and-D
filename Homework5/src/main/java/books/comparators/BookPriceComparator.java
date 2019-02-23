package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        return (int)(first.getPrice() - second.getPrice());
    }
}
