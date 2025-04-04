import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Router {
    public static void main(String[] args) {
        try{
                System.out.println("waiting for packets");
                byte b[]=new byte[200];
                ServerSocket serverSocket=new ServerSocket(1111);
                Socket socket=serverSocket.accept();
                DataInputStream is= new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                FileOutputStream fr=new FileOutputStream("Router_File.txt");
                int bytesRead;
                while ((bytesRead = is.read(b)) != -1) {
                  fr.write(b,0,bytesRead);
                }
                is.close();
                fr.close();
                dataOutputStream.close();
                System.out.println("Packet Received");
                serverSocket.close();
                  
            }catch(IOException e){
                System.out.println("Packet not received");
            }
       try{
            RandomAccessFile Routers_RandomaccessFile = new RandomAccessFile("Router_File.txt","rw");
            Routers_RandomaccessFile.seek(880);
            String Destination_IP=Routers_RandomaccessFile.readLine();
            Routers_RandomaccessFile.close();
          
              Scanner input_Scanner = new Scanner(System.in);
              System.out.println("Enter 1:Just Forward");
              System.out.println("Enter 2:Attack and Farward");
              System.out.println("Enter 3:Don't Forward");
              int Forward=input_Scanner.nextInt();
              input_Scanner.close();
              if (Forward==1) {
                try{
                  Socket socket1 = new Socket(Destination_IP,1212);
                  FileInputStream fileInputStream=new FileInputStream("Router_File.txt");
                  DataOutputStream dataOutputStream1 =new DataOutputStream(socket1.getOutputStream());
                  byte[] b1=new byte[200];
                  int bytesRead1;
                  while((bytesRead1=fileInputStream.read(b1))!=-1){
                      dataOutputStream1.write(b1, 0, bytesRead1);
                      dataOutputStream1.flush();
                  }
                  fileInputStream.close();
                  dataOutputStream1.close();
                  socket1.close();
                }catch(IOException er){
                  System.out.println("Packet can't transmit");
               }
              }
              else if (Forward==2) {
                try{
                  RandomAccessFile routerAccessFile = new RandomAccessFile("Router_File.txt","rw");
                  routerAccessFile.seek(20);
                  String attack_Contents="+-@!3";
                  routerAccessFile.writeBytes(attack_Contents);
                  routerAccessFile.close();
                  Socket socket2 = new Socket(Destination_IP,1212);
                  FileInputStream fileInputStream1=new FileInputStream("Router_File.txt");
                  DataOutputStream dataOutputStream2=new DataOutputStream(socket2.getOutputStream());
                  byte[] b2=new byte[200];
                  int bytesRead1;
                  while((bytesRead1=fileInputStream1.read(b2))!=-1){
                      dataOutputStream2.write(b2, 0, bytesRead1);
                      dataOutputStream2.flush();
                  }
                  fileInputStream1.close();
                  dataOutputStream2.close();
                  socket2.close();
                }catch(IOException er){
                  System.out.println("ERROR");
               }
              }
              if (Forward==3) {
                System.exit(0);
              } 
            
          }catch(IOException er){
            System.out.println("ERROR");
          }
    }
}
