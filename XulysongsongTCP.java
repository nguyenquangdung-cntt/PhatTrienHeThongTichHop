import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class XulysongsongTCP extends Thread {
    Socket channel;

    public XulysongsongTCP(Socket s) {
        channel = s;
    }

    public void run() {
        try {
            OutputStream os = channel.getOutputStream();
            InputStream is = channel.getInputStream();
            while (true) {
                int n = is.read();
                if (n == -1)
                    break;
                os.write(n);
            }
        } catch (IOException e) {
            System.out.println("Xu ly song song bi loi: " + e);
        }
    }
}
