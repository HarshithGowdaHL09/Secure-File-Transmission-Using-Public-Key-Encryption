import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
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

public class Sender{   
    public static void main(String[] args) {
        ImageIcon logo = new ImageIcon("logo1.jpg");
        JPanel SFTP_panel=new JPanel();
        JFrame SFTP_Window=new JFrame("Sender");
        SFTP_Window.setSize(1100,600);
        SFTP_Window.setLayout(new BoxLayout( SFTP_Window.getContentPane(),BoxLayout.Y_AXIS));
        SFTP_Window.setIconImage(logo.getImage());
        
        JMenuBar menuBar = new JMenuBar();
    
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu algorithMenu = new JMenu("Algorithm");
        JMenu helpMenu = new JMenu("Help");
        JMenu transfermMenu = new JMenu("Transfer");

        JMenuItem ShareItem = new JMenuItem("Share to other Computer");
        transfermMenu.add(ShareItem);

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

        JMenuItem RSA_MenuItem = new JMenuItem("RSA");
        JMenuItem Substitution_MenuItem = new JMenuItem("Substitution");
        JMenuItem mac_MenuItem = new JMenuItem("MAC Algorithm");
        Asymmtricalgorithm.add(RSA_MenuItem);
        Symmetricalgraithm.add(Substitution_MenuItem);
        MAC_Algorithm.add(mac_MenuItem);
       
        JLabel Sender_Label=new JLabel("SENDER");
        Sender_Label.setFont(new Font("Serif",Font.BOLD,25));
        Sender_Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel palinText_cipherText_Lable = new JLabel("Plain Text                                                           Cipher Text");
        palinText_cipherText_Lable.setFont(new Font("Serif",Font.BOLD,25));
        palinText_cipherText_Lable.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel whiteSpace_Label = new JLabel("                            ");
        whiteSpace_Label.setFont(new Font("Serif",Font.BOLD,25));
        
        JTextArea plainText_TextArea = new JTextArea(15,30);
        plainText_TextArea.setFont(new Font("Serif",Font.BOLD , 20));
        plainText_TextArea.setLineWrap(true);
        plainText_TextArea.setWrapStyleWord(true);
        
        JTextArea cipherText_TextArea = new JTextArea(15,30);
        cipherText_TextArea.setFont(new Font("Serif",Font.BOLD , 20));
        cipherText_TextArea.setLineWrap(true);
        cipherText_TextArea.setWrapStyleWord(true);
        cipherText_TextArea.setEditable(false);
        
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    FileReader PlaintFile_fileReader = new FileReader("PlainFile.txt");
                    char[] charArray = new char[200];
                    PlaintFile_fileReader.read(charArray);
                    PlaintFile_fileReader.close();
                    plainText_TextArea.setText(String.valueOf(charArray));
                }catch(IOException erorr){
                    JOptionPane.showMessageDialog(SFTP_Window, "Unable to open", "Open", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        savItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File New_PlainTextFile=new File("PlainFile.txt");
                try{
                    New_PlainTextFile.createNewFile();
                }catch(IOException erorr){
                    JOptionPane.showMessageDialog(SFTP_Window,"ERORR IN FILE CREATION","Save",JOptionPane.INFORMATION_MESSAGE);
                }
                try{
                    String plain_Contents=plainText_TextArea.getText();
                    FileWriter fileWriter=new FileWriter("PlainFile.txt");
                    fileWriter.write(plain_Contents);
                    fileWriter.close();
                    JOptionPane.showMessageDialog(SFTP_Window,"File successfully saved","Save",JOptionPane.INFORMATION_MESSAGE);
                }catch(IOException erorr){
                    JOptionPane.showMessageDialog(SFTP_Window,"ERORR IN FILE SAVE","Save",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        RSA_MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog RSA_Dialog = new JDialog(SFTP_Window,"RSA Algorithm");
                RSA_Dialog.setSize(460,240);
                RSA_Dialog.setAlwaysOnTop(true);
                RSA_Dialog.setLocationRelativeTo(SFTP_Window);
                JPanel RSA_panel = new JPanel();

                JLabel PrimeNumbers_Label=new JLabel("      Enter two digits Prime number");
                PrimeNumbers_Label.setFont(new Font("Serif",Font.BOLD,20));

                JLabel prime_Number_p=new JLabel("Enter a Prime Number P");
                prime_Number_p.setFont(new Font("Serif",Font.BOLD,15));

                JTextField prime_num_p_TextField = new JTextField(15);
                prime_num_p_TextField.setFont(new Font("Serif",Font.BOLD,15));

                JLabel prime_num_q = new JLabel("Enter a Prime Number q");
                prime_num_q.setFont(new Font("Serif",Font.BOLD,15));

                JTextField prime_num_q_TextField = new JTextField(15);
                prime_num_q_TextField.setFont(new Font("Serif",Font.BOLD,15));

                JButton Encrypt_Button = new JButton("Encrypt");
                Encrypt_Button.setPreferredSize(new Dimension(100,50));
                Encrypt_Button.setFont(new Font("Serif",Font.BOLD,17));

                JLabel whiteSpace_Label=new JLabel("                                                                                          ");
                whiteSpace_Label.setFont(new Font("Serif",Font.BOLD,15));

                Encrypt_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //RSA algorithm implementation
                        int p = Integer.parseInt(prime_num_p_TextField.getText()); 
                        int q = Integer.parseInt(prime_num_q_TextField.getText()); 
		                int msg;
		                double c;
		                int en;
                        if (p>=10 && q>=10) {
                            boolean flag= false;
                        for(int i=2; i<=p/2; i++){
                                if (p%i == 0) {
                                    flag = true;
                                    break;
                                }
                        }
                       
                        boolean flag1= false;
                        for(int i=2; i<=q/2; i++){
                                if (q%i == 0) {
                                    flag1 = true;
                                    break;
                                }
                        }
                        if (!flag && !flag1) {
                            // Step 2: Calculate n and phi
                            int n = p * q;
                            int phi = (p - 1) * (q - 1);
		                    char ch;
                            // Step 3: Choose public key e1
                            for (en = 2; en < phi; en++) {
                                // e is for public key exponent
                                if (gcd(en, phi) == 1) {
                                    break;
                                 }
                            }
                            int d = calculateD(en, phi);

                            try{
                                Socket socket = new Socket("localhost",1551);
                                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                dataOutputStream.writeInt(n);
                                dataOutputStream.writeInt(d);
                                dataOutputStream.close();
                                socket.close();
                            }catch(IOException error){
                                System.out.println("Error to transmit private key");
                            }
                            try{
                                File encrypt_File=new File("encrypt_File.txt");
                                encrypt_File.createNewFile();
                                FileReader PlaintFile_fileReader=new FileReader("PlainFile.txt");
                                FileWriter encrypt_File_FileWriter=new FileWriter("encrypt_File.txt");
                                while ((msg=PlaintFile_fileReader.read())!=-1) {
                                    c = (Math.pow(msg, en)) % n;
                                    ch=(char)c;
                                    encrypt_File_FileWriter.write(ch);
                                }
                                PlaintFile_fileReader.close();
                                encrypt_File_FileWriter.close();
                            
                            }catch(IOException erorr){
                                System.out.println("ERORR");
                            }
                            try{
                                FileReader encrypt_File_Reader=new FileReader("encrypt_File.txt");
                                char[] charArray =new char[100];
                                encrypt_File_Reader.read(charArray);
                                encrypt_File_Reader.close();
                                cipherText_TextArea.setText(String.valueOf(charArray));
                            }catch(IOException erorr){
                                System.out.println("ERORR");
                            }
                            JOptionPane.showMessageDialog(RSA_Dialog, "Contents are Encrypted","Save",JOptionPane.INFORMATION_MESSAGE);
                            plainText_TextArea.setEditable(false);
                            RSA_Dialog.dispose();
                            }else{
                                prime_num_p_TextField.setText("");
                                prime_num_q_TextField.setText("");
                                JOptionPane.showMessageDialog(RSA_Dialog, "Enter only prime numbers", "Not Prime", JOptionPane.WARNING_MESSAGE);                       
                            }
                        }else{
                            prime_num_p_TextField.setText("");
                            prime_num_q_TextField.setText("");
                            JOptionPane.showMessageDialog(RSA_Dialog, "Enter two digits number","RSA",JOptionPane.WARNING_MESSAGE);
                        }
                        
                   }
                });
                RSA_panel.add(PrimeNumbers_Label);
                RSA_panel.add(prime_Number_p);
                RSA_panel.add(prime_num_p_TextField);
                RSA_panel.add(prime_num_q);
                RSA_panel.add(prime_num_q_TextField);
                RSA_panel.add(whiteSpace_Label);
                RSA_panel.add(Encrypt_Button);

                RSA_Dialog.add(RSA_panel);
                RSA_Dialog.setVisible(true);
                 
            }
        });
        
        Substitution_MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog Substitution_Dialog = new JDialog(SFTP_Window,"Substitution Algoritm");
                Substitution_Dialog.setSize(440,240);
                Substitution_Dialog.setLocationRelativeTo(SFTP_Window);
                
                JPanel Substitution_panel = new JPanel();

                JLabel substitution_Label = new JLabel("Encrypt the contents by using Substitution Algorithm");
                substitution_Label.setFont(new Font("Serif",Font.BOLD,18));

                JLabel SecretKey_Lable = new JLabel("Enter a secert key eg..1,2,20....N");
                SecretKey_Lable.setFont(new Font("Serif",Font.BOLD,21));

                JLabel whiteSpace_Label=new JLabel("                                                                                          ");
                whiteSpace_Label.setFont(new Font("Serif",Font.BOLD,15));
                whiteSpace_Label.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField secretKey_TextField = new JTextField(15);
                secretKey_TextField.setFont(new Font("Serif",Font.BOLD,25));

                JButton encrypt_Button = new JButton("Encrypt");
                encrypt_Button.setFont(new Font("Serif",Font.BOLD,18));
                encrypt_Button.setPreferredSize(new Dimension(100,30));

                encrypt_Button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String message=plainText_TextArea.getText();
                        int Secret=Integer.parseInt(secretKey_TextField.getText());
                        String encrypt="";
                        int i;
                        for (i=0; i<message.length();i++){
                          char ch = message.charAt(i);
                          ch += Secret;
                          encrypt=encrypt+ch;
                        }
                        cipherText_TextArea.setText(String.valueOf(encrypt));
                        try{
                            FileWriter encryptFile_Writer = new FileWriter("encrypt_File.txt");
                            encryptFile_Writer.write(encrypt);
                            encryptFile_Writer.close();
                            JOptionPane.showMessageDialog(Substitution_Dialog, "Contents Encrypted", "Encryption", JOptionPane.INFORMATION_MESSAGE);
                        }catch(IOException error){
                            JOptionPane.showMessageDialog(Substitution_Dialog, "Contents unable Encrypted", "Encryption", JOptionPane.INFORMATION_MESSAGE);
                        }
                        plainText_TextArea.setEditable(false);
                        Substitution_Dialog.dispose();
                    }
            });

                Substitution_panel.add(substitution_Label);
                Substitution_panel.add(SecretKey_Lable);
                Substitution_panel.add(whiteSpace_Label);
                Substitution_panel.add(secretKey_TextField);
                Substitution_panel.add(encrypt_Button);
                Substitution_Dialog.add(Substitution_panel);
                Substitution_Dialog.setVisible(true);
            }
        });
        ShareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog share_Dialog = new JDialog(SFTP_Window,"Share");
                share_Dialog.setSize(440,240);
                share_Dialog.setLocationRelativeTo(SFTP_Window);

                JPanel share_Panel = new JPanel();

                JLabel share_Label = new JLabel("Share the file by following");
                share_Label.setFont(new Font("Serif",Font.BOLD,20));

                JLabel ip_Label = new JLabel("Enter the IP Address of the computer which computer ");
                ip_Label.setFont(new Font("Serif",Font.BOLD,17));

                JLabel ip_Label2 = new JLabel("                                 you want to send                                                ");
                ip_Label2.setFont(new Font("Serif",Font.BOLD,17));
                
                JTextField ipAddress_TextField = new JTextField(10);
                ipAddress_TextField.setFont(new Font("Serif",Font.BOLD,25));

                JButton send_Button = new JButton("Send");
                send_Button.setFont(new Font("Serif",Font.BOLD,18));
                send_Button.setPreferredSize(new Dimension(100,34));

                send_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            String Destination_IP =ipAddress_TextField.getText();
                            RandomAccessFile encryptAccessFile = new RandomAccessFile("encrypt_File.txt", "rw");
                            encryptAccessFile.seek(880);
                            encryptAccessFile.writeBytes(Destination_IP);
                            encryptAccessFile.close();
                            
                            Socket socket = new Socket("localhost",1111);
                            FileInputStream fileInputStream=new FileInputStream("encrypt_File.txt");
                            DataOutputStream dataOutputStream =new DataOutputStream(socket.getOutputStream());
                            byte[] b=new byte[200];
                            int bytesRead;
                            while((bytesRead=fileInputStream.read(b))!=-1){
                                dataOutputStream.write(b, 0, bytesRead);
                                dataOutputStream.flush();
                            }
                            fileInputStream.close();
                            dataOutputStream.close();
                            JOptionPane.showMessageDialog(share_Dialog, "File Successfully send", "Transmitted",JOptionPane.INFORMATION_MESSAGE );
                            share_Dialog.dispose();
                            socket.close();
                        }catch(IOException erorr){
                                System.out.println("Error occured while transmitting file");
                            }
                            
                    }
                });
                share_Panel.add(share_Label);
                share_Panel.add(ip_Label);
                share_Panel.add(ip_Label2);
                share_Panel.add(ipAddress_TextField);
                share_Panel.add(send_Button);
                share_Dialog.add(share_Panel);
                share_Dialog.setVisible(true);
            }
        });
        mac_MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog MAC_Dialog = new JDialog(SFTP_Window,"MAC Algorithm");
                MAC_Dialog.setSize(440,240);
                MAC_Dialog.setLocationRelativeTo(SFTP_Window);

                JPanel MAC_panel = new JPanel();
                
                JLabel MAC_Label = new JLabel("Generate the MAC code by following");
                MAC_Label.setFont(new Font("Serif",Font.BOLD,20));

                JLabel MAC_Label2 = new JLabel("MAC code will be generated automatically");
                MAC_Label2.setFont(new Font("Serif",Font.BOLD,20));

                JButton MAC_code_Button = new JButton("MAC");
                MAC_code_Button.setFont(new Font("Serif",Font.BOLD,17));
                MAC_code_Button.setPreferredSize(new Dimension(100,50));

                MAC_code_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            FileReader PlaintFile_fileReader = new FileReader("PlainFile.txt");
                            long Mac=0;
                            int n;
                            while ((n=PlaintFile_fileReader.read())!=-1) {
                                Mac = Mac+n;
                            }
                            PlaintFile_fileReader.close();
                            RandomAccessFile encryptAccessFile = new RandomAccessFile("encrypt_File.txt", "rw");
                            encryptAccessFile.seek(500);
                            encryptAccessFile.writeLong(Mac);
                            encryptAccessFile.close();
                            JOptionPane.showMessageDialog(MAC_Dialog,"MAC code being generated and append to the file","MAC",JOptionPane.INFORMATION_MESSAGE);
                            }catch (IOException erorr){
                                 JOptionPane.showMessageDialog(MAC_Dialog,"Some error occured while generating MAC code","MAC",JOptionPane.INFORMATION_MESSAGE);
                            }  
                            MAC_Dialog.dispose(); 
                               
                    }   
                });
                MAC_panel.add(MAC_Label);
                MAC_panel.add(MAC_Label2);
                MAC_panel.add(MAC_code_Button);
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

        helpMenu.add("If you need any help, contact us with this Moblie number 123456789");
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(algorithMenu);
        menuBar.add(transfermMenu);
        menuBar.add(helpMenu);
        SFTP_Window.setJMenuBar(menuBar);

        SFTP_panel.add(plainText_TextArea);
        SFTP_panel.add(cipherText_TextArea);

        SFTP_Window.add(Sender_Label);
        SFTP_Window.add(whiteSpace_Label);
        SFTP_Window.add(palinText_cipherText_Lable);

        SFTP_Window.add(SFTP_panel);

        SFTP_Window.setVisible(true);
        try{
                    ServerSocket serverSocket = new ServerSocket(1552);
                    Socket socket=serverSocket.accept();
                    DataInputStream  dataInputStream = new DataInputStream(socket.getInputStream());
                    String reply = dataInputStream.readUTF();
                    System.out.println(reply);
                    serverSocket.close();
                }catch(IOException error){
                    System.out.println("ERROR");
                }  
    } 
	static int gcd(int e, int phi){
        if (e == 0)
            return phi;
        else
            return gcd(phi % e, e);
    }
    static int calculateD(int e, int phi) {
        int d = 1;
        while (((d * e) % phi) != 1) {
            d++;
        }
        return d;
    }
}