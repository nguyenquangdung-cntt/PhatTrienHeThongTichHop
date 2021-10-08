import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class severTCPss {
    public final static int severPort = 7;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(severPort);
            System.out.println("Server da duoc tao");
            while (true) {
                try {
                    Socket s = ss.accept();
                    XulysongsongTCP p = new XulysongsongTCP(s);
                    p.start();
                } catch (IOException ie1) {
                    System.out.println("ERROR !!!!!" + ie1);
                }
            }
        } catch (IOException ie) {
            System.out.println("ERROR !!!!!" + ie);
        }
    }
}
