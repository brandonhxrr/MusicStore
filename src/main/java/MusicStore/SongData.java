package MusicStore;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class SongData implements Serializable {
    String Name;
    String Artist;
    ImageIcon image;
    String path;
    int Price;
    int index;

    public SongData(String Path, String Name, String Artist, ImageIcon image, int Price, int Index) {
        this.path = Path;
        this.Name = Name;
        this.Artist = Artist;
        this.image = image;
        this.Price = Price;
        this.index = Index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
    
}
