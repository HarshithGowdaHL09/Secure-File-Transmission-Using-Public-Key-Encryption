import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA2 {

    public static void main(String[] args) {
        // Step 1: Choose two prime numbers
        int p = 17; 
        int q =11; 
		int msg;
		int e;
		BigInteger msgback;
        // Step 2: Calculate n and phi
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        // Step 3: Choose public key e1
        for (e = 2; e < phi; e++) {
 
            // e is for public key exponent
            if (gcd(e, phi) == 1) {
                break;
            }
        }
        // Step 4: Calculate private key d
        int d = calculateD(e, phi);
        System.out.println("the value of e ="+e);
		System.out.println("the value of d = " + d);
        try
                               {
                                File filew = new File("Decrypted_File.txt");
                                filew.createNewFile();
                                 FileReader  fr=new    FileReader("encrypt_File.txt");
                                 FileWriter fileWriter2 = new FileWriter("Decrypted_File.txt");
                                 while( (msg=fr.read())!=-1)
                                 {  
                                        //System.out.print(msg);
                                    BigInteger N=BigInteger.valueOf(n);
                                    BigInteger C=BigDecimal.valueOf(msg).toBigInteger();
                                    msgback=(C.pow(d)).mod(N);
                                    //System.out.println("Decrypted msg:"+msgback);
                                    int a1=msgback.intValue();
                                    char original_mes=(char)a1;
                                    fileWriter2.write(original_mes);
                                 } 
                                 fr.close( );
                                fileWriter2.close();
                               }
                              catch(IOException e1)
                              {
                                 System.out.println("Error in File Read");
                              }  
					
	}
    // Function to calculate private key (d)
    static int calculateD(int e, int phi) {
        int d = 1;
        while (((d * e) % phi) != 1) {
            d++;
        }

        return d;
    }

	static int gcd(int e, int phi)
    {
        if (e == 0)
            return phi;
        else
            return gcd(phi % e,e);
    }
}