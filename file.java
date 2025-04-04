import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class file {

     public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("PlainFile.txt");
            long Mac=0;
            int n;
            while ((n=fileReader.read())!=-1) {
                System.out.println(n);
                Mac = Mac+n;

            }
            fileReader.close();
            RandomAccessFile randomAccessFile = new RandomAccessFile("encrypt_File.txt", "rw");
            randomAccessFile.seek(100);
            randomAccessFile.writeLong(Mac);
            System.out.println(Mac);
            randomAccessFile.close();
        }catch (IOException e){

        }        
     }
}