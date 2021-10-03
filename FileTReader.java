package Tuan03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileTReader implements Runnable {
    String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileTReader(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int a;
            while ((a = br.read()) != -1) {
                System.out.println(this.getFilename() + ": " + a);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        FileReader tr1 = new FileReader("D:\\test\\tes1.txt");
        FileReader tr2 = new FileReader("D:\\test\\tes2.txt");

        tr1.start();
        tr2.start();
    }
}
