import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit;

public class Receiver {

    public static void main(String[] args) {

        ImageIcon logo = new ImageIcon("logo1.jpg");

        JPanel SFTP_panel =new JPanel();

        JFrame SFTP_Window = new JFrame("Receiver");
        SFTP_Window.setSize(1100,600);
        SFTP_Window.setLayout(new BoxLayout( SFTP_Window.getContentPane(),BoxLayout.Y_AXIS));
        SFTP_Window.setIconImage(logo.getImage());

        JMenuBar menuBar = new JMenuBar();
    
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu algorithMenu = new JMenu("Algorithm");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem savItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem openItem = new JMenuItem("Open");

        JMenuItem capyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        capyItem.setText("Copy");

        JMenuItem cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
        cutItem.setText("Cut");

        JMenuItem pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        pasteItem.setText("Paste");
        
        JMenu Asymmtricalgorithm = new JMenu("Asymmtric");
        JMenu Symmetricalgraithm = new JMenu("Symmetric");
        JMenu MAC_Algorithm = new JMenu("MAC Code");

        JMenuItem RSA_Algorithm = new JMenuItem("RSA");
        JMenuItem Substitution_Algorithm = new JMenuItem("Substitution");
        JMenuItem mac_MenuItem = new JMenuItem("MAC Algorithm");
        
        Asymmtricalgorithm.add(RSA_Algorithm);
        Symmetricalgraithm.add(Substitution_Algorithm);
        MAC_Algorithm.add(mac_MenuItem);


        JLabel pupUp_label = new JLabel();
        pupUp_label.setFont(new Font("Serif",Font.BOLD,25));
        pupUp_label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel receiver_Label = new JLabel("Receiver");
        receiver_Label.setFont(new Font("Serif",Font.BOLD,25));
        receiver_Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cipherPlainText_Label = new JLabel("Cipher Text                                               Plain Text");
        cipherPlainText_Label.setFont(new Font("Serif",Font.BOLD,25));
        cipherPlainText_Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea cipherText_TextArea = new JTextArea(15,30);
        cipherText_TextArea.setFont(new Font("Serif",Font.BOLD,20));
        cipherText_TextArea.setLineWrap(true);
        cipherText_TextArea.setWrapStyleWord(true);
        cipherText_TextArea.setEditable(false);

        JTextArea plainText_TextArea = new JTextArea(15,30);
        plainText_TextArea.setFont(new Font("Serif",Font.BOLD,20));
        plainText_TextArea.setLineWrap(true);
        plainText_TextArea.setWrapStyleWord(true);
        try{
            System.out.println("Waiting for private key from sender");
            ServerSocket serverSocket = new ServerSocket(1551);
            Socket socket=serverSocket.accept();
            DataInputStream  dataInputStream = new DataInputStream(socket.getInputStream());
            int nn=dataInputStream.readInt();
            int dd=dataInputStream.readInt();
            File file = new File("Private_Key.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("Private_Key.txt");
            fileWriter.write(nn);
            fileWriter.write(dd);
            fileWriter.close();
            System.out.println("n value:  "+nn);
            System.out.println("d value:  "+dd);
            serverSocket.close();
        }catch(IOException error){
            System.out.println("Private key not received");
        }
        try{
                System.out.println("waiting for clients");
                byte b[]=new byte[200];
                ServerSocket serverSocket=new ServerSocket(1212);
                Socket socket=serverSocket.accept();
                DataInputStream is= new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                FileOutputStream fr=new FileOutputStream("Encrypted_File.txt");
                int bytesRead;
                while ((bytesRead = is.read(b)) != -1) {
                  fr.write(b,0,bytesRead);
                }
                is.close();
                fr.close();
                dataOutputStream.close();
                pupUp_label.setText("File Received");
                System.out.println("File Received");
                serverSocket.close();        
            }catch(IOException e){
                System.out.println("File not received");
            }
        
        try{
            FileReader receivedFile_Reader = new FileReader("Encrypted_File.txt");
            char[] charArray=new char[200];
            receivedFile_Reader.read(charArray);
            receivedFile_Reader.close();
            cipherText_TextArea.setText(String.valueOf(charArray));
        }catch(IOException error){
            System.out.println("Erorr");
        }
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     FileReader encrypt_File_Reader = new FileReader("Encrypted_File.txt");
                    char[] charArray=new char[100];
                    encrypt_File_Reader.read(charArray);
                    encrypt_File_Reader.close();
                    cipherText_TextArea.setText(String.valueOf(charArray));
                }catch(IOException error){
                     System.out.println("Erorr");
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        RSA_Algorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog RSA_Dialog = new JDialog(SFTP_Window,"RSA Decryption");
                RSA_Dialog.setSize(440,240);
                RSA_Dialog.setLocationRelativeTo(SFTP_Window);

                JPanel RSA_panel = new JPanel();

                JLabel RSA_Label1 = new JLabel("Decrypt the file by following");
                RSA_Label1.setFont(new Font("Serif",Font.BOLD,20));

                JLabel prime_num_q_Label = new JLabel("Private key is received from sender");
                prime_num_q_Label.setFont(new Font("Serif",Font.BOLD,16));

                JLabel whiteSpace_Label = new JLabel("                                                                                                           ");
                JButton decrypt_Button = new JButton("Decrypt");
                decrypt_Button.setFont(new Font("Serif",Font.BOLD,15));
                decrypt_Button.setPreferredSize(new Dimension(100,50));

                decrypt_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            FileReader encryptFile_Reader= new FileReader("Encrypted_File.txt");
                            BufferedReader bufferedReader = new BufferedReader(encryptFile_Reader);
                            char[] buffer = new char[200];
                            int charsRead = bufferedReader.read(buffer,0,199);
                            String firsString = new String(buffer,0,charsRead);
                            encryptFile_Reader.close();
                            bufferedReader.close();
                            File file = new File("Temp.txt");
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter("Temp.txt");
                            fileWriter.write(firsString);
                            fileWriter.close();
                            //RSA Algorithm implementation
		                    int msg;
                            BigInteger msgback;
                           
                                FileReader reader = new FileReader("Private_Key.txt");
                                int n=reader.read();
                                int d=reader.read();
                                reader.close();
                                try{
                                        File decryptFile = new File("Decrypted_File.txt");
                                        decryptFile.createNewFile();
                                        FileReader temp_FileReader=new FileReader("Temp.txt");
                                        FileWriter decryptFile_Writer = new FileWriter("Decrypted_File.txt");
                                        while( (msg=temp_FileReader.read())!=-1)
                                        {  
                                            BigInteger N=BigInteger.valueOf(n);
                                            BigInteger C=BigDecimal.valueOf(msg).toBigInteger();
                                            msgback=(C.pow(d)).mod(N);
                                            int a1=msgback.intValue();
                                            char original_mes=(char)a1;
                                            decryptFile_Writer.write(original_mes);
                                        } 
                                        temp_FileReader.close( );
                                        decryptFile_Writer.close();
                                        try{
                                            FileReader decrypt_FileReader = new FileReader("Decrypted_File.txt");
                                            char[] charArray = new char[459];
                                            decrypt_FileReader.read(charArray);
                                            decrypt_FileReader.close();
                                            plainText_TextArea.setText(String.valueOf(charArray));
                                            plainText_TextArea.setEditable(false);
                                            JOptionPane.showMessageDialog(RSA_Dialog, "File Decrypted Scussfully", "Decrypted",JOptionPane.INFORMATION_MESSAGE);
                                            RSA_Dialog.dispose();
                                      } catch (IOException error){
                                            JOptionPane.showMessageDialog(RSA_Dialog, "File Unable To Decrypted", "Decrypted",JOptionPane.INFORMATION_MESSAGE);
                                            RSA_Dialog.dispose();
                                      }
                                    }
                                    catch(IOException e1)
                                    {
                                     System.out.println("Error in File Read");
                                    }  
                         
                            
                            }catch(IOException error){
                                JOptionPane.showMessageDialog(RSA_Dialog,"Error in Decryption", "Error",JOptionPane.INFORMATION_MESSAGE);
                            } 
                    }
                });
                RSA_panel.add(RSA_Label1);
                RSA_panel.add(prime_num_q_Label);
                RSA_panel.add(whiteSpace_Label);
                RSA_panel.add(decrypt_Button);
                RSA_Dialog.add(RSA_panel);
                RSA_Dialog.setVisible(true);
            }
        });
        Substitution_Algorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog substitution_Dialog = new JDialog(SFTP_Window,"Substitution Algorithm Decryption");
                substitution_Dialog.setSize(440,240);
                substitution_Dialog.setLocationRelativeTo(SFTP_Window);
                
                JPanel substitution_Panel = new JPanel();

                JLabel substitution_Label = new JLabel("Decrypt the file by following and enter same secret key used by the sender");
                substitution_Label.setFont(new Font("Serif",Font.BOLD,13));

                JLabel whiteSpace_Label = new JLabel("                                               ");
                whiteSpace_Label.setFont(new Font("Serif",Font.BOLD,25));

                JLabel secretKey_Label = new JLabel("Enter the Secret key");
                secretKey_Label.setFont(new Font("Serif",Font.BOLD,20));

                JTextField secretKey_TextField = new JTextField(15);
                secretKey_TextField.setFont(new Font("Serif",Font.BOLD,20));

                JButton decrypt_Button = new JButton("Decrypt");
                decrypt_Button.setFont(new Font("Serif",Font.BOLD,15));
                decrypt_Button.setPreferredSize(new Dimension(100,30));

                decrypt_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String encrypt = cipherText_TextArea.getText();
                            int Secret=Integer.parseInt(secretKey_TextField.getText());
                              String decrypted="";
                              int i;
                              for (i=0; i<encrypt.length();i++){
                                char ch = encrypt.charAt(i);
                                ch -= Secret;
                                decrypted=decrypted+ch;
                              }
                              try{
                                    FileWriter decryptFile_Writer = new FileWriter("Decrypted_File.txt");
                                    decryptFile_Writer.write(decrypted);
                                    decryptFile_Writer.close();
                              }catch(IOException erorr){
                                System.out.println("Error");
                              }
                              plainText_TextArea.setText(String.valueOf(decrypted));
                              JOptionPane.showMessageDialog(substitution_Dialog, "File Successfully Decrypted", "Substitution algorithm Decryption", JOptionPane.INFORMATION_MESSAGE);
                              substitution_Dialog.dispose();
                    }
                });
                substitution_Panel.add(substitution_Label);
                substitution_Panel.add(whiteSpace_Label);
                substitution_Panel.add(secretKey_Label);
                substitution_Panel.add(secretKey_TextField);
                substitution_Panel.add(decrypt_Button);
                substitution_Dialog.add(substitution_Panel);
                substitution_Dialog.setVisible(true);
            }
        });
        mac_MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog MAC_Dialog = new JDialog(SFTP_Window,"MAC");
                MAC_Dialog.setSize(440,240);
                MAC_Dialog.setLocationRelativeTo(SFTP_Window);
                
                JPanel MAC_panel = new JPanel();

                JLabel MAC_Label = new JLabel("Compare the MAC code by following");
                MAC_Label.setFont(new Font("Serif",Font.BOLD,20));

                JLabel MAC_Label2 = new JLabel("MAC Code will be generated automatically and ");
                MAC_Label2.setFont(new Font("Serif",Font.BOLD,17));

                JLabel MAC_Label3 = new JLabel("  compared with Received MAC Code");
                MAC_Label3.setFont(new Font("Serif",Font.BOLD,17));

                JLabel whiteSpace_Label = new JLabel("                           ");

                JButton mac_Button = new JButton("MAC");
                mac_Button.setFont(new Font("Serif",Font.BOLD,18));
                mac_Button.setPreferredSize(new Dimension(100,50));

                mac_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                            try{
                                RandomAccessFile encryptAccessFile = new RandomAccessFile("Encrypted_File.txt", "r");
                                encryptAccessFile.seek(500);
                                long Mac_code=encryptAccessFile.readLong();
                                encryptAccessFile.close();
                                FileReader decrypt_FileReader = new FileReader("Decrypted_File.txt");
                                long Mac=0;
                                int n1;
                                while ((n1=decrypt_FileReader.read())!=-1) {
                                    Mac = Mac + n1;
                                }
                                decrypt_FileReader.close();
                                if (Mac_code == Mac) {
                                    JOptionPane.showMessageDialog(MAC_Dialog,"Message not altered", "MAC", JOptionPane.INFORMATION_MESSAGE);
                                    try{
                                        Socket socket = new Socket("localhost",1552);
                                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                        dataOutputStream.writeUTF("Receiver: File Received successfully");
                                        dataOutputStream.close();
                                        socket.close();
                                    }catch(IOException error){
                                        System.out.println("Error");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(MAC_Dialog,"Message has been altered", "MAC", JOptionPane.INFORMATION_MESSAGE);
                                    try{
                                        Socket socket = new Socket("localhost",1552);
                                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                        dataOutputStream.writeUTF("Receiver: File contents modified due to attack, can you retransmit the file");
                                        dataOutputStream.close();
                                        socket.close();
                                    }catch(IOException error){
                                        System.out.println("Error");
                                    }
                                }
                                MAC_Dialog.dispose();
                                
                            }catch(IOException error){ }
                    }
                });
                MAC_panel.add(MAC_Label);
                MAC_panel.add(MAC_Label2);
                MAC_panel.add(MAC_Label3);
                MAC_panel.add(whiteSpace_Label);
                MAC_panel.add(mac_Button);
                MAC_Dialog.add(MAC_panel);
                MAC_Dialog.setVisible(true);
            }
        });
        fileMenu.add(loadItem);
        fileMenu.add(openItem);
        fileMenu.add(savItem);
        fileMenu.add(exitItem);

        editMenu.add(capyItem);
        editMenu.add(pasteItem);
        editMenu.add(cutItem);

        algorithMenu.add(Asymmtricalgorithm);
        algorithMenu.add(Symmetricalgraithm);
        algorithMenu.add(MAC_Algorithm);

        helpMenu.add("If you need any help please contact us with this Moblie number 123456789");
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(algorithMenu);
        menuBar.add(helpMenu);
        
        SFTP_Window.setJMenuBar(menuBar);

        SFTP_panel.add(cipherText_TextArea);
        SFTP_panel.add(plainText_TextArea);

        SFTP_Window.add(pupUp_label);
        SFTP_Window.add(receiver_Label);
        SFTP_Window.add(cipherPlainText_Label);
        SFTP_Window.add(SFTP_panel);
        
        SFTP_Window.setVisible(true);

    }
   
}