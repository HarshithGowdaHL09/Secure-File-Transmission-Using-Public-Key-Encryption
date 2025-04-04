import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;

public class fileTest {

     public static void main(String[] args) {
        try{
            FileReader fReader = new FileReader("Encrypted_File.txt");
            BufferedReader bufferedReader = new BufferedReader(fReader);
            char[] buffer = new char[100];
            int charsRead = bufferedReader.read(buffer,0,100);
            String firsString = new String(buffer,0,charsRead);
            System.out.println(firsString);
            fReader.close();
            bufferedReader.close();
            File file = new File("Temp.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("Temp.txt");
            fileWriter.write(firsString);
            fileWriter.close();
            int p, q, n, d = 0;

            // The number to be encrypted and decrypted
            int msg;
            
            BigInteger msgback;
     
            // 1st prime number p
            p = 17;
     
            // 2nd prime number q
            q =11;
            n = p * q;
            d=23;
    
             try
               {
                File filew = new File("Decrypted_File.txt");
                filew.createNewFile();
                 FileReader  fr=new    FileReader("Temp.txt");
                 FileWriter fileWriter2 = new FileWriter("Decrypted_File.txt");
                 while( (msg=fr.read())!=-1)
                 {  
                        //System.out.print(msg);
                    BigInteger N=BigInteger.valueOf(n);
                    BigInteger C=BigDecimal.valueOf(msg).toBigInteger();
                    msgback=(C.pow(d)).mod(N);
                    //System.out.println("Decrypted msg:"+msgback);
                    int a=msgback.intValue();
                    char original_mes=(char)a;
                    fileWriter2.write(original_mes);
                 } 
                 fr.close( );
                fileWriter2.close();
                
               }
              catch(IOException e1)
              {
                 System.out.println("Error in File Read");
              } 
              try{
            RandomAccessFile randomAccessFile = new RandomAccessFile("Encrypted_File.txt", "r");
            randomAccessFile.seek(100);
            long Mac_code=randomAccessFile.readLong();
            randomAccessFile.close();
            System.out.println(Mac_code);
            FileReader fileReader = new FileReader("Decrypted_File.txt");
            long Mac=0;
            int n1;
            while ((n1=fileReader.read())!=-1) {
                Mac = Mac + n1;
            }System.out.println(Mac);
            fileReader.close();
            if (Mac_code == Mac) {
                System.out.println("Message not been altered");
            }else{
                System.out.println("Message has been altered");
            }
        }catch(IOException error){ }
        }catch(IOException e){

        }
    }
}