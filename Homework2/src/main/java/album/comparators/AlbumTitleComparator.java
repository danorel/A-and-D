package album.comparators;

import album.Album;

import java.util.Comparator;

public class AlbumTitleComparator implements Comparator<Album> {
    public int compare(Album firstAlbum, Album secondAlbum) {
        return firstAlbum.getTitle().compareTo(secondAlbum.getTitle());
    }
}
