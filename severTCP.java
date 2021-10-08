import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class severTCP {
    public final static int severPort = 7;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(severPort);
            System.out.println("Sever da duoc tao");
            while (true) {
                try {
                    Socket s = ss.accept();
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read();
                        if (ch == 1)
                            break;
                        System.out.println((char) ch);
                        os.write(ch);
                    }
                    s.close();
                } catch (IOException ie1) {
                    System.out.println("Ket noi bi loi: " + ie1);
                }
            }
        } catch (Exception ie) {
            System.out.println("Ket noi bi loi: " + ie);
        }
    }

}