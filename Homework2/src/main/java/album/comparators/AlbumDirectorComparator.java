package album.comparators;

import album.Album;

import java.util.Comparator;

public class AlbumDirectorComparator implements Comparator<Album> {
    public int compare(Album firstAlbum, Album secondAlbum) {
        return firstAlbum.getDirector().compareTo(secondAlbum.getDirector());
    }
}
