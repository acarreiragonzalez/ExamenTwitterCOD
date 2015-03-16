











package examencod;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author acarreiragonzalez
 */
public class ExamenCOD {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {

        String busqueda;
        String tweet;
        int opcion;

        MetodosTwitter obj = new MetodosTwitter();

    
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> TimeLine\n2 --> Buscar\n3 --> Tweettear\n4 --> Exit"));
            switch (opcion) {
                case 1:
                    obj.lineaTiempo();
                    break;
                case 2:
                    busqueda = JOptionPane.showInputDialog("Busca tweet");
                    obj.buscarString(busqueda);
                    break;
                case 3:
                    tweet = JOptionPane.showInputDialog("Escribe Tweet");
                    obj.tweetear(tweet);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opcion != 0 && opcion != 4);
    }
}
