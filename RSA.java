import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RSA {

    public static void main(String[] args) {

        // Step 1: Choose two prime numbers
        int p = 59; 
        int q =11; 
		int msg;
		double c;
		int e;

        boolean flag= false;
        for(int i=2; i<=p/2; i++){
            if (p%i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        // Step 2: Calculate n and phi
        int n = p * q;
        int phi = (p - 1) * (q - 1);
		char ch;
        // Step 3: Choose public key e1
        for (e = 2; e < phi; e++) {
 
            // e is for public key exponent
            if (gcd(e, phi) == 1) {
                break;
            }
        }
        // Step 4: Calculate private key d
       // int d = calculatePrivateKey(e, phi);

		//System.out.println("the value of d = " + d);
         try{
                            File file=new File("encrypt_File.txt");
                            file.createNewFile();
                            FileReader fileReader=new FileReader("PlainFile.txt");
                            FileWriter writer=new FileWriter("encrypt_File.txt");
                            while ((msg=fileReader.read())!=-1) {
                                c = (Math.pow(msg, e)) % n;
                                ch=(char)c;
                                writer.write(ch);
                            }
                            fileReader.close();
                            writer.close();
                            
                        }catch(IOException erorr){
                            System.out.println("ERORR");

                        }
					
	}
    // Function to calculate private key (d)
    // private static int calculatePrivateKey(int e, int phi) {
    //     int d = 1;

    //     while ((d * e) % phi != 1) {
    //         d++;
    //     }

    //     return d;
    //}

	static int gcd(int e, int phi)
    {
        if (e == 0)
            return phi;
        else
            return gcd(phi % e, e);
    }
}