import books.Book;
import books.comparators.*;
import sorters.Sorter;
import sorters.algorithms.*;

public class App {
    public static void main(String[] args) {
        Book[] library = new Book[4];
        library[0] = new Book("Forever", "Daniel", 174, 99.99);
        library[1] = new Book("Love", "Olia", 984, 999.99);
        library[2] = new Book("True", "Life", 64, 43.99);
        library[3] = new Book("Sincerely", "Me", 84 , 75.55);
        Sorter<Book> sorter = new Sorter<Book>();
        sorter.setCurrentSortStrategy(new InsertionSort()).setArray(library).sort(new BookPriceComparator(), "DESC").showArray();
    }
}
