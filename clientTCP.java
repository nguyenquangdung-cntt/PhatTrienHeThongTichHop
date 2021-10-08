import java.io.*;
import java.net.Socket;

public class clientTCP {
    public final static String severIP = "127.0.0.1";
    public final static int severPort = 7;
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        try {
            s = new Socket(severIP, severPort);
            System.out.println("Client da duoc tao");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            for (int i = '0'; i <= '9'; i++) {
                os.write(i);
                int ch = is.read();
                System.out.println((char)ch);
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            System.out.println("Error: Can Not create socket");
        }finally{
            if(s != null){
                s.close();
            }
        }
    }
}
