package MusicStore;

import static MusicStore.Main.icon;
import java.io.File;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Servidor {


    public static void main(String[] args) {

        listSongs("src/main/java/canciones/");

    }
    
    public static void listSongs(String ruta_archivos) {

        File f = new File(ruta_archivos);
        File[] ficheros = f.listFiles();

        try {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Servidor iniciado");
            for (;;) {
                Socket cl = ss.accept();
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                
                List<SongData> canciones = new ArrayList<>();
                int i = 0;

                for (File fichero: ficheros) {
                    
                    Song s = null;
                    
                    AudioFile af = AudioFileIO.read(fichero);
                    Tag tag = af.getTag();
                    icon = getArtwork(tag);
                    
                    canciones.add(new SongData(tag.getFirst(FieldKey.TITLE), tag.getFirst(FieldKey.ARTIST), icon, i, i, fichero));
                    i++;
                }
                
                oos.writeObject(canciones);

                oos.flush();
                System.out.println("Cliente conectado.. Enviando objeto con los datos\nX:");
               
                oos.close();
                cl.close();
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon getArtwork(Tag tag) {
        ImageIcon artwork;

        try {
            byte[] bytes = tag.getFirstArtwork().getBinaryData();
            artwork = new ImageIcon(bytes);
        } catch (Exception ex) {
            artwork = new ImageIcon("src/main/java/images/album.jpg");

        }
        return artwork;
    }

}