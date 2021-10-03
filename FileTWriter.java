package Tuan03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.Thread;

/**
 * FileTWriter
 */
public class FileTWriter implements Runnable {
    String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileTWriter(String t1) {
        this.filename = t1;
    }

    public FileTWriter(FileWriter t1) {
    }

    @Override
    public void run() {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 10; i++) {
                int rand = (int) (Math.random() * 10);
                bw.write(rand + "\t");
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable t1 = new FileTWriter("D:\\test\\test1.txt");
        Thread th1 = new Thread(t1);
        th1.start();

        Runnable t2 = new FileTWriter("D:\\test\\test2.txt");
        Thread th2 = new Thread(t2);
        th2.start();
    }

}