package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        return first.getAuthor().compareTo(second.getAuthor());
    }
}
