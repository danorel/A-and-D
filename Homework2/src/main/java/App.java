import album.Album;
import album.comparators.AlbumDirectorComparator;
import sorters.Sorter;

public class App {
    public static void main(String[] args) {
        // Testing the album sorting
        Album []albums = new Album[3];
        albums[0] = new Album();
        albums[0].setTitle("Hello, June!").setDirector("Daniel Orel").setPrice(500.99);
        albums[1] = new Album();
        albums[1].setTitle("Ohh, March!").setDirector("Oliver Koletzki").setPrice(123.49);
        albums[2] = new Album();
        albums[2].setTitle("I love U more than anything...").setDirector("Olia Perch").setPrice(999.99);
        Sorter<Album> albumSorter = new Sorter<Album>();
        albumSorter.setComparator(new AlbumDirectorComparator()).setArray(albums).insertionSort().showArray();

        // Testing the Integer sorting
        System.out.println();
        Integer ints[] = new Integer[]{-1, 20, 50, -4, 5};
        Sorter<Integer> integerSorter = new Sorter<Integer>();
        integerSorter.setArray(ints).brushSort().showArray();
    }
}
