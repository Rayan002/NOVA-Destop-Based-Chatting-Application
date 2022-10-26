//import com.chatting_application.demoClient;
//
//import javax.xml.namespace.QName;
//import java.sql.*;
//
//
//public class User1 {
//    public static String n1;
//    public static void main(String[] args) {
//        try{
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","1234");
//
//            Statement sts = con.createStatement();
//            ResultSet resultSet = sts.executeQuery("select * from users");
//
//            while(resultSet.next()){
//               n1 ="name1";
//                resultSet.getString("name");
//                if(n1.equals(resultSet.getObject("name"))){
////                    new demoClient().setVisible(true);
//            }
//               else{
//                    System.out.println("Invalid");
//                }
//
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//DATABASE CONNECTION

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;

//==========================================================================================================================//
                                                   //server..//

class Server extends JFrame implements ActionListener{

    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea tf1;
    JScrollPane sb;

    //network
    static ServerSocket skt;
    static Socket s;

    static DataInputStream din;
    static DataOutputStream dout;

    public Server() {

        //green navbar
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 400, 70);
        add(p1);


        // exit button - icon no.01
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(5, 25, 20, 20);
        p1.add(l1);

        //mouseevent for exit
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });


        // DP - icon no.02
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/elon.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);

        l2.setBounds(30, 5, 60, 60);
        p1.add(l2);

        // Video call - icon no.02
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l3 = new JLabel(i9);

        l3.setBounds(230, 15, 40, 40);
        p1.add(l3);

        //Audio call - icon no.03
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l4 = new JLabel(i12);

        l4.setBounds(290, 16, 40, 40);
        p1.add(l4);

        //More options - icon no.04
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(12, 22, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l5 = new JLabel(i15);

        l5.setBounds(335, 15, 40, 40);
        p1.add(l5);


        //Name - text no.01
        JLabel l6 = new JLabel("Elon Musk");
        l6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        l6.setForeground(Color.WHITE);
        l6.setBounds(95, 16, 100, 40);
        p1.add(l6);

        //send text field
        t1 = new JTextField();
        t1.setBounds(5, 555, 300, 40);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);

        //send button
        b1 = new JButton("Send");
        b1.setBounds(310, 555, 85, 40);
        b1.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(7, 94, 84));
//        b1.addActionListener(this);
        add(b1);

        //text field
        // display area.
        tf1 = new JTextArea();

        tf1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        tf1.setBackground(Color.white);
        tf1.setEditable(false);
        tf1.setLineWrap(true);
        tf1.setWrapStyleWord(true);

        // adding scroll bar
        sb = new JScrollPane(tf1);
        sb.setBounds(5, 75, 390, 475);
        sb.addNotify();
        add(sb);
        setLayout(null);

        //Window box - Server
        setSize(400, 600);
        setLocation(200, 70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String out = t1.getText();
        tf1.setText(tf1.getText() + "\n\n\t\t" + out);
        try {
            dout.writeUTF(out);
        } catch (IOException aae) {
            aae.printStackTrace();
        }
        t1.setText("");
    }
}

//==========================================================================================================================//
                                                //ERROR PAGE//

     class Error_thrower_server extends JFrame {

        JLabel lb1;
        JButton b1;

        public Error_thrower_server() {


            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/1.1.png"));
            Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3);

            l1.setBounds(0, 0, 0, 0);
            add(l1);


            lb1 = new JLabel("ERROR");
            lb1.setBounds(2, 2, 300, 300);
            lb1.setForeground(Color.red);
            lb1.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
            lb1.setLocation(219, 83);
            l1.add(lb1);

            setSize(450, 550);
            setLocation(450, 120);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);


        }
    }


    //==========================================================================================================================//
                                                          //LOGIN PAGE//
    class login extends JFrame {
        public void mess() {
            System.out.println("connection successfull");
        }

        JPanel p1;
        JLabel l1;
        JLabel l2;
        JTextField t1;
        JLabel l3;
        JPasswordField t2;
        JButton b1;
        JButton b2;
        JLabel l4;
        JLabel l5;
        JLabel l6;


        login() {

            p1 = new JPanel();
            p1.setBounds(0, 0, 1000, 500);
            p1.setBackground(new Color(7, 94, 84));
            p1.setLayout(null);
            add(p1);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/loginback.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel bg = new JLabel(i3);
            bg.setBounds(0, 0, 1000, 500);
            p1.add(bg);

            l1 = new JLabel("Login Form");
            l1.setBounds(645, -190, 1000, 500);
            l1.setFont(new Font("SANS_SERIF", Font.BOLD, 28));
            l1.setForeground(Color.white);
            bg.add(l1);


            l2 = new JLabel("Email:");
            l2.setBounds(600, -130, 1000, 500);
            l2.setFont(new Font("SANS_SERIF", Font.BOLD, 18));
            l2.setForeground(Color.white);
            bg.add(l2);

            t1 = new JTextField("Email");
            t1.setBounds(600, 150, 250, 30);
            t1.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
            t1.setForeground(Color.black);
            bg.add(t1);


            l3 = new JLabel("Password:");
            l3.setBounds(600, -25, 1000, 500);
            l3.setFont(new Font("SANS_SERIF", Font.BOLD, 18));
            l3.setForeground(Color.white);
            bg.add(l3);


            t2 = new JPasswordField("Password");
            t2.setBounds(600, 255, 250, 30);
            t2.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
            t2.setForeground(Color.black);
            bg.add(t2);


            b1 = new JButton("LogIn");
            b1.setBounds(615, 320, 100, 30);
            b1.setForeground(Color.black);
            b1.setBackground(Color.white);
            bg.add(b1);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "1234");

                        Statement sts = con.createStatement();
                        ResultSet resultSet = sts.executeQuery("select * from users where name = '" + t1.getText() + "' and password = '" + t2.getText().toString() + "'");

                        if (resultSet.next()) {
                            Server obj2 = new Server();
                        } else {
                            Error_thrower_server obj1 = new Error_thrower_server();
                        }

                        con.close();

                    } catch (Exception ae) {
                        ae.printStackTrace();
                    }

                }
            });

            b1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent ae) {
                    b1.setBackground(new Color(58, 111, 89));
                }

                @Override
                public void mouseExited(MouseEvent ae) {
                    b1.setBackground(Color.white);
                }
            });


            b2 = new JButton("Cancel");
            b2.setBounds(735, 320, 100, 30);
            b2.setForeground(Color.black);
            b2.setBackground(Color.white);
            bg.add(b2);

            b2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                    b2.setBackground(new Color(58, 111, 89));
                }

                public void mouseExited(MouseEvent e) {
                    b2.setBackground(Color.white);
                }
            });


            l4 = new JLabel("N🌖VA");
            l4.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 70));
            l4.setBounds(200, -80, 500, 500);
            l4.setForeground(Color.white);
            bg.add(l4);

            l5 = new JLabel("Chatting");
            l5.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
            l5.setBounds(200, -0, 500, 500);
            l5.setForeground(Color.white);
            bg.add(l5);

            l6 = new JLabel("App");
            l6.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
            l6.setBounds(200, 25, 500, 500);
            l6.setForeground(Color.white);
            bg.add(l6);

            setSize(1000, 500);
            setLocation(200, 130);
            setLayout(null);
            setUndecorated(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

        }
    }


    class democlass {
        public static void main(String[] args) {
            login a = new login();
        }
    }