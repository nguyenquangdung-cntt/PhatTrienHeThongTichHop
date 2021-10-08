import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Bai01server {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server da duoc mo");
            Socket clientSocket = null;
            clientSocket = serverSocket.accept();
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());
            String inline = "";
            while (true) {
                inline = dis.readUTF();
                char ch[] = inline.toCharArray();
                if (Character.isDigit(ch[0])) {
                    int i = Integer.parseInt(inline);
                    switch (i) {
                        case 0:
                            inline = "Không";
                            break;
                        case 1:
                            inline = "Một";
                            break;
                        case 2:
                            inline = "Hai";
                            break;
                        case 3:
                            inline = "Ba";
                            break;
                        case 4:
                            inline = "Bốn";
                            break;
                        case 5:
                            inline = "Năm";
                            break;
                        case 6:
                            inline = "Sáu";
                            break;
                        case 7:
                            inline = "Bảy";
                            break;
                        case 8:
                            inline = "Tám";
                            break;
                        case 9:
                            inline = "Chín";
                            break;

                    }
                    dos.writeUTF(inline);
                } else {
                    dos.writeUTF("Không phải số nguyên");
                }
            }
        } catch (Exception e) {
            dos.close();
            serverSocket.close();
            dis.close();
            System.out.println(e.getMessage());
        }
    }
}
