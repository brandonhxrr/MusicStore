package MusicStore;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import javax.swing.ImageIcon;

public class SongData implements Serializable {
    String Name;
    String Artist;
    ImageIcon image;
    byte[] fileContent;
    int Price;
    int index;

    public SongData(String Name, String Artist, ImageIcon image, int Price, int Index, File file) throws IOException {
        this.fileContent = Files.readAllBytes(file.toPath());
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

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
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
