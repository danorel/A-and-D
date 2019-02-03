package album.comparators;

import album.Album;

import java.util.Comparator;

public class AlbumPriceComparator implements Comparator<Album> {
    public int compare(Album firstAlbum, Album secondAlbum) {
        return (int)(firstAlbum.getPrice() - secondAlbum.getPrice());
    }
}
