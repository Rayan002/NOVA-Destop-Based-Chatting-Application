import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


public class SQLjava extends JFrame {


    JLabel lb1;
    JButton b1;
    JLabel in;

    public SQLjava() {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/undraw2.png"));
        Image i2 = i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0,0,0,0);
        add(l1);



        lb1 = new JLabel("ERROR");
        lb1.setBounds(2,2,300,300);
        lb1.setForeground(Color.red);
        lb1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        lb1.setLocation(219,83);
        l1.add(lb1);


//        b1 = new JButton();
//        b1.setBorderPainted(false);
////        b1.setBounds(0,260,90,35);
//        b1.setSize(90,35);
//        b1.setLocation(-60,260);
//        lb1.add(b1);

        ;



        setSize(450,550);
        setLocation(450,120);
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);

//        JLabel l1 =  new JLabel("Hello world.");
//        add(l1);// adding this mandatory otherwise it will not be going to appear.


    }

    public static void main(String[] args) {

        new SQLjava();
    }
}