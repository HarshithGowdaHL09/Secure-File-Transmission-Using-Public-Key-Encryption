import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame {
    public static void main(String[] args) {
         ImageIcon logo = new ImageIcon("logo1.jpg");
        JFrame SFTP_Window=new JFrame("Sender");
        SFTP_Window.setSize(350,400);
        SFTP_Window.setLayout(new BoxLayout( SFTP_Window.getContentPane(),BoxLayout.Y_AXIS));
        SFTP_Window.setIconImage(logo.getImage());
        SFTP_Window.setVisible(true);
    }
}
