package Tuan03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.Thread;

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
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable t1 = new FileTReader("D:\\PTTHHT\\BtTh\\Tuan03\\test\\test1.txt");
        Thread th1 = new Thread(t1);
        th1.start();

        Runnable t2 = new FileTReader("D:\\PTTHHT\\BtTh\\Tuan03\\test\\test2.txt");
        Thread th2 = new Thread(t2);
        th2.start();
    }
}
