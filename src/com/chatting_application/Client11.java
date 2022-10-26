package com.chatting_application;//import java.io.*;
//import java.net.*;
//
//public class Client11 {
//    public static void main(String[] args) {
//        try {
//            String sentence;
//            String modifiedSentence;
//
//            Socket clientSocket = new Socket("localhost", 6680);
//
//            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            System.out.println("Enter the message for server:");
//            sentence = inFromUser.readLine();
//
//            outToServer.writeBytes(sentence + '\n');
//            modifiedSentence = inFromServer.readLine();
//            System.out.println("FROM SERVER: " + modifiedSentence);
//            clientSocket.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}


/* SERVER CODE PURESTED FORM

//package com.chatting_application;
//
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.net.*;
//import java.io.*;
//
//import java.util.Calendar;
//import java.text.SimpleDateFormat;
//
//public class Server1 implements ActionListener{
//
//    JPanel p1;
//    JTextField t1;
//    JButton b1;
//    static JPanel a1;
//    static JFrame f1 = new JFrame();
//
//    static Box vertical = Box.createVerticalBox();
//
//    static ServerSocket skt;
//    static Socket s;
//    static DataInputStream din;
//    static DataOutputStream dout;
//
//    Boolean typing;
//
//    Server1(){
//        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(7, 94, 84));
//        p1.setBounds(0, 0, 450, 70);
//        f1.add(p1);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l1 = new JLabel(i3);
//        l1.setBounds(5, 17, 30, 30);
//        p1.add(l1);
//
//        l1.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent ae){
//                System.exit(0);
//            }
//        });
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
//        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel l2 = new JLabel(i6);
//        l2.setBounds(40, 5, 60, 60);
//        p1.add(l2);
//
//        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
//        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i9 = new ImageIcon(i8);
//        JLabel l5 = new JLabel(i9);
//        l5.setBounds(290, 20, 30, 30);
//        p1.add(l5);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
//        Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
//        ImageIcon i13 = new ImageIcon(i12);
//        JLabel l6 = new JLabel(i13);
//        l6.setBounds(350, 20, 35, 30);
//        p1.add(l6);
//
//        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
//        Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
//        ImageIcon i16 = new ImageIcon(i15);
//        JLabel l7 = new JLabel(i16);
//        l7.setBounds(410, 20, 13, 25);
//        p1.add(l7);
//
//
//        JLabel l3 = new JLabel("Gaitonde");
//        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        l3.setForeground(Color.WHITE);
//        l3.setBounds(110, 15, 100, 18);
//        p1.add(l3);
//
//
//        JLabel l4 = new JLabel("Active Now");
//        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
//        l4.setForeground(Color.WHITE);
//        l4.setBounds(110, 35, 100, 20);
//        p1.add(l4);
//
//        Timer t = new Timer(1, new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                if(!typing){
//                    l4.setText("Active Now");
//                }
//            }
//        });
//
//        t.setInitialDelay(2000);
//
//
//        a1 = new JPanel();
//        a1.setBounds(5, 75, 440, 570);
//        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(a1);
//
//
//        t1 = new JTextField();
//        t1.setBounds(5, 655, 310, 40);
//        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(t1);
//
//        t1.addKeyListener(new KeyAdapter(){
//            public void keyPressed(KeyEvent ke){
//                l4.setText("typing...");
//
//                t.stop();
//
//                typing = true;
//            }
//
//            public void keyReleased(KeyEvent ke){
//                typing = false;
//
//                if(!t.isRunning()){
//                    t.start();
//                }
//            }
//        });
//
//        b1 = new JButton("Send");
//        b1.setBounds(320, 655, 123, 40);
//        b1.setBackground(new Color(7, 94, 84));
//        b1.setForeground(Color.WHITE);
//        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        b1.addActionListener(this);
//        f1.add(b1);
//
//        f1.getContentPane().setBackground(Color.WHITE);
//        f1.setLayout(null);
//        f1.setSize(450, 700);
//        f1.setLocation(400, 200);
//        f1.setUndecorated(true);
//        f1.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        try{
//            String out = t1.getText();
//
//            JPanel p2 = formatLabel(out);
//
//            a1.setLayout(new BorderLayout());
//
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//
//            a1.add(vertical, BorderLayout.PAGE_START);
//
//            //a1.add(p2);
//            dout.writeUTF(out);
//            t1.setText("");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public static JPanel formatLabel(String out){
//        JPanel p3 = new JPanel();
//        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
//
//        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
//        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        l1.setBackground(new Color(37, 211, 102));
//        l1.setOpaque(true);
//        l1.setBorder(new EmptyBorder(15,15,15,50));
//
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//        JLabel l2 = new JLabel();
//        l2.setText(sdf.format(cal.getTime()));
//
//        p3.add(l1);
//        p3.add(l2);
//        return p3;
//    }
//
//    public static void main(String[] args){
//        new Server1().f1.setVisible(true);
//
//        String msginput = "";
//        try{
//            skt = new ServerSocket(6001);
//            while(true){
//                s = skt.accept();
//                din = new DataInputStream(s.getInputStream());
//                dout = new DataOutputStream(s.getOutputStream());
//
//                while(true){
//                    msginput = din.readUTF();
//                    JPanel p2 = formatLabel(msginput);
//
//                    JPanel left = new JPanel(new BorderLayout());
//                    left.add(p2, BorderLayout.LINE_START);
//                    vertical.add(left);
//                    f1.validate();
//                }
//
//            }
//
//        }catch(Exception e){}
//    }
//}
package com.chatting_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Server1 extends JFrame implements ActionListener {

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

    public Server1() {

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
        b1.addActionListener(this);
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


//        getContentPane().setBackground(Color.yellow);//background color
        setLayout(null);

        //Window box - Server
        setSize(400, 600);
        setLocation(200, 70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }


    // for overriding in action performed for exit
    public void actionPerformed(ActionEvent ae) {

        String out = t1.getText();
        tf1.setText(tf1.getText() + "\n\n\t\t" + out);
        //network
        try {
            dout.writeUTF(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        t1.setText("");

    }

    public static void main(String[] args) {

        new Server1().setVisible(true);
        String textinput = "";
        try{
            skt = new ServerSocket(6000);
            s= skt.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while(!textinput.equals("Exit")) {
                textinput = din.readUTF();
                tf1.setText(tf1.getText() + "\n\n  " + textinput);
            }
            skt.close();
            s.close();

        }
        catch(Exception e){e.printStackTrace();}
    }
}
 */

/*  CLIENT CODE PUREST FORM
//package com.chatting_application;
//
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.net.*;
//import java.io.*;
//
//import java.util.Calendar;
//import java.text.SimpleDateFormat;import javax.swing.*;
//
//public class Client1 implements ActionListener{
//
//    JPanel p1;
//    JTextField t1;
//    JButton b1;
//    static JPanel a1;
//    static JFrame f1 = new JFrame();
//
//    static Box vertical = Box.createVerticalBox();
//
//
//    static Socket s;
//    static DataInputStream din;
//    static DataOutputStream dout;
//
//    Boolean typing;
//
//    Client1(){
//        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(7, 94, 84));
//        p1.setBounds(0, 0, 450, 70);
//        f1.add(p1);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l1 = new JLabel(i3);
//        l1.setBounds(5, 17, 30, 30);
//        p1.add(l1);
//
//        l1.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent ae){
//                System.exit(0);
//            }
//        });
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
//        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel l2 = new JLabel(i6);
//        l2.setBounds(40, 5, 60, 60);
//        p1.add(l2);
//
//        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
//        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i9 = new ImageIcon(i8);
//        JLabel l5 = new JLabel(i9);
//        l5.setBounds(290, 20, 30, 30);
//        p1.add(l5);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
//        Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
//        ImageIcon i13 = new ImageIcon(i12);
//        JLabel l6 = new JLabel(i13);
//        l6.setBounds(350, 20, 35, 30);
//        p1.add(l6);
//
//        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
//        Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
//        ImageIcon i16 = new ImageIcon(i15);
//        JLabel l7 = new JLabel(i16);
//        l7.setBounds(410, 20, 13, 25);
//        p1.add(l7);
//
//
//        JLabel l3 = new JLabel("Bunty");
//        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        l3.setForeground(Color.WHITE);
//        l3.setBounds(110, 15, 100, 18);
//        p1.add(l3);
//
//
//        JLabel l4 = new JLabel("Active Now");
//        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
//        l4.setForeground(Color.WHITE);
//        l4.setBounds(110, 35, 100, 20);
//        p1.add(l4);
//
//        Timer t = new Timer(1, new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                if(!typing){
//                    l4.setText("Active Now");
//                }
//            }
//        });
//
//        t.setInitialDelay(2000);
//
//        a1 = new JPanel();
//        a1.setBounds(5, 75, 440, 570);
//        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(a1);
//
//
//        t1 = new JTextField();
//        t1.setBounds(5, 655, 310, 40);
//        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(t1);
//
//        t1.addKeyListener(new KeyAdapter(){
//            public void keyPressed(KeyEvent ke){
//                l4.setText("typing...");
//
//                t.stop();
//
//                typing = true;
//            }
//
//            public void keyReleased(KeyEvent ke){
//                typing = false;
//
//                if(!t.isRunning()){
//                    t.start();
//                }
//            }
//        });
//
//        b1 = new JButton("Send");
//        b1.setBounds(320, 655, 123, 40);
//        b1.setBackground(new Color(7, 94, 84));
//        b1.setForeground(Color.WHITE);
//        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        b1.addActionListener(this);
//        f1.add(b1);
//
//        f1.getContentPane().setBackground(Color.WHITE);
//        f1.setLayout(null);
//        f1.setSize(450, 700);
//        f1.setLocation(1100, 200);
//        f1.setUndecorated(true);
//        f1.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//
//        try{
//            String out = t1.getText();
//
//            JPanel p2 = formatLabel(out);
//
//            a1.setLayout(new BorderLayout());
//
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//
//            a1.add(vertical, BorderLayout.PAGE_START);
//
//            //a1.add(p2);
//            dout.writeUTF(out);
//            t1.setText("");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public static JPanel formatLabel(String out){
//        JPanel p3 = new JPanel();
//        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
//
//        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
//        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        l1.setBackground(new Color(37, 211, 102));
//        l1.setOpaque(true);
//        l1.setBorder(new EmptyBorder(15,15,15,50));
//
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//        JLabel l2 = new JLabel();
//        l2.setText(sdf.format(cal.getTime()));
//
//        p3.add(l1);
//        p3.add(l2);
//        return p3;
//    }
//
//    public static void main(String[] args){
//        new Client1().f1.setVisible(true);
//
//        try{
//
//            s = new Socket("127.0.0.1", 6001);
//            din  = new DataInputStream(s.getInputStream());
//            dout = new DataOutputStream(s.getOutputStream());
//
//            String msginput = "";
//
//            while(true){
//                a1.setLayout(new BorderLayout());
//                msginput = din.readUTF();
//                JPanel p2 = formatLabel(msginput);
//                JPanel left = new JPanel(new BorderLayout());
//                left.add(p2, BorderLayout.LINE_START);
//
//                vertical.add(left);
//                vertical.add(Box.createVerticalStrut(15));
//                a1.add(vertical, BorderLayout.PAGE_START);
//                f1.validate();
//            }
//
//        }catch(Exception e){}
//    }
//}

package com.chatting_application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Client1 extends JFrame implements ActionListener {

    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea tf1;
    JScrollPane sb;

    //network
    static Socket s1;
    static DataInputStream din1;
    static DataOutputStream dout1;

    public Client1() {

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
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/astronaut.png"));
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
        b1.addActionListener(this);
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


//        getContentPane().setBackground(Color.yellow);//background color
        setLayout(null);

        //Window box - Server
        setSize(400, 600);
        setLocation(700, 70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }


    // for overriding in action performed for exit
    public void actionPerformed(ActionEvent ae) {

        String out = t1.getText();
        tf1.setText(tf1.getText() + "\n\n\t\t" + out);
        try {
            dout1.writeUTF(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        t1.setText("");

    }

    public static void main(String[] args) {
        new Client1().setVisible(true);
        String textinput = "";
        try{

            s1= new Socket("127.0.0.1",6000);
            din1 = new DataInputStream(s1.getInputStream());
            dout1 = new DataOutputStream(s1.getOutputStream());

            while(!textinput.equals("Exit")) {
                textinput = din1.readUTF();
                tf1.setText(tf1.getText() + "\n\n  " + textinput);
            }
            s1.close();
        }
        catch(Exception e){e.printStackTrace();}
    }
}
 */

//package com.chatting_application;
//
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.net.*;
//import java.io.*;
//
//import java.util.Calendar;
//import java.text.SimpleDateFormat;import javax.swing.*;
//
//public class Client1 implements ActionListener{
//
//    JPanel p1;
//    JTextField t1;
//    JButton b1;
//    static JPanel a1;
//    static JFrame f1 = new JFrame();
//
//    static Box vertical = Box.createVerticalBox();
//
//
//    static Socket s;
//    static DataInputStream din;
//    static DataOutputStream dout;
//
//    Boolean typing;
//
//    Client1(){
//        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(7, 94, 84));
//        p1.setBounds(0, 0, 450, 70);
//        f1.add(p1);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l1 = new JLabel(i3);
//        l1.setBounds(5, 17, 30, 30);
//        p1.add(l1);
//
//        l1.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent ae){
//                System.exit(0);
//            }
//        });
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
//        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel l2 = new JLabel(i6);
//        l2.setBounds(40, 5, 60, 60);
//        p1.add(l2);
//
//        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
//        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i9 = new ImageIcon(i8);
//        JLabel l5 = new JLabel(i9);
//        l5.setBounds(290, 20, 30, 30);
//        p1.add(l5);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
//        Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
//        ImageIcon i13 = new ImageIcon(i12);
//        JLabel l6 = new JLabel(i13);
//        l6.setBounds(350, 20, 35, 30);
//        p1.add(l6);
//
//        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
//        Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
//        ImageIcon i16 = new ImageIcon(i15);
//        JLabel l7 = new JLabel(i16);
//        l7.setBounds(410, 20, 13, 25);
//        p1.add(l7);
//
//
//        JLabel l3 = new JLabel("Bunty");
//        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        l3.setForeground(Color.WHITE);
//        l3.setBounds(110, 15, 100, 18);
//        p1.add(l3);
//
//
//        JLabel l4 = new JLabel("Active Now");
//        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
//        l4.setForeground(Color.WHITE);
//        l4.setBounds(110, 35, 100, 20);
//        p1.add(l4);
//
//        Timer t = new Timer(1, new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                if(!typing){
//                    l4.setText("Active Now");
//                }
//            }
//        });
//
//        t.setInitialDelay(2000);
//
//        a1 = new JPanel();
//        a1.setBounds(5, 75, 440, 570);
//        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(a1);
//
//
//        t1 = new JTextField();
//        t1.setBounds(5, 655, 310, 40);
//        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(t1);
//
//        t1.addKeyListener(new KeyAdapter(){
//            public void keyPressed(KeyEvent ke){
//                l4.setText("typing...");
//
//                t.stop();
//
//                typing = true;
//            }
//
//            public void keyReleased(KeyEvent ke){
//                typing = false;
//
//                if(!t.isRunning()){
//                    t.start();
//                }
//            }
//        });
//
//        b1 = new JButton("Send");
//        b1.setBounds(320, 655, 123, 40);
//        b1.setBackground(new Color(7, 94, 84));
//        b1.setForeground(Color.WHITE);
//        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        b1.addActionListener(this);
//        f1.add(b1);
//
//        f1.getContentPane().setBackground(Color.WHITE);
//        f1.setLayout(null);
//        f1.setSize(450, 700);
//        f1.setLocation(1100, 200);
//        f1.setUndecorated(true);
//        f1.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//
//        try{
//            String out = t1.getText();
//
//            JPanel p2 = formatLabel(out);
//
//            a1.setLayout(new BorderLayout());
//
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//
//            a1.add(vertical, BorderLayout.PAGE_START);
//
//            //a1.add(p2);
//            dout.writeUTF(out);
//            t1.setText("");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public static JPanel formatLabel(String out){
//        JPanel p3 = new JPanel();
//        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
//
//        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
//        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        l1.setBackground(new Color(37, 211, 102));
//        l1.setOpaque(true);
//        l1.setBorder(new EmptyBorder(15,15,15,50));
//
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//        JLabel l2 = new JLabel();
//        l2.setText(sdf.format(cal.getTime()));
//
//        p3.add(l1);
//        p3.add(l2);
//        return p3;
//    }
//
//    public static void main(String[] args){
//        new Client1().f1.setVisible(true);
//
//        try{
//
//            s = new Socket("127.0.0.1", 6001);
//            din  = new DataInputStream(s.getInputStream());
//            dout = new DataOutputStream(s.getOutputStream());
//
//            String msginput = "";
//
//            while(true){
//                a1.setLayout(new BorderLayout());
//                msginput = din.readUTF();
//                JPanel p2 = formatLabel(msginput);
//                JPanel left = new JPanel(new BorderLayout());
//                left.add(p2, BorderLayout.LINE_START);
//
//                vertical.add(left);
//                vertical.add(Box.createVerticalStrut(15));
//                a1.add(vertical, BorderLayout.PAGE_START);
//                f1.validate();
//            }
//
//        }catch(Exception e){}
//    }
//}

//package com.chatting_application;
//
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.net.*;
//import java.io.*;
//
//import java.util.Calendar;
//import java.text.SimpleDateFormat;
//
//public class Server1 implements ActionListener{
//
//    JPanel p1;
//    JTextField t1;
//    JButton b1;
//    static JPanel a1;
//    static JFrame f1 = new JFrame();
//
//    static Box vertical = Box.createVerticalBox();
//
//    static ServerSocket skt;
//    static Socket s;
//    static DataInputStream din;
//    static DataOutputStream dout;
//
//    Boolean typing;
//
//    Server1(){
//        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(7, 94, 84));
//        p1.setBounds(0, 0, 450, 70);
//        f1.add(p1);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
//        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l1 = new JLabel(i3);
//        l1.setBounds(5, 17, 30, 30);
//        p1.add(l1);
//
//        l1.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent ae){
//                System.exit(0);
//            }
//        });
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
//        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel l2 = new JLabel(i6);
//        l2.setBounds(40, 5, 60, 60);
//        p1.add(l2);
//
//        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
//        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//        ImageIcon i9 = new ImageIcon(i8);
//        JLabel l5 = new JLabel(i9);
//        l5.setBounds(290, 20, 30, 30);
//        p1.add(l5);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
//        Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
//        ImageIcon i13 = new ImageIcon(i12);
//        JLabel l6 = new JLabel(i13);
//        l6.setBounds(350, 20, 35, 30);
//        p1.add(l6);
//
//        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
//        Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
//        ImageIcon i16 = new ImageIcon(i15);
//        JLabel l7 = new JLabel(i16);
//        l7.setBounds(410, 20, 13, 25);
//        p1.add(l7);
//
//
//        JLabel l3 = new JLabel("Gaitonde");
//        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        l3.setForeground(Color.WHITE);
//        l3.setBounds(110, 15, 100, 18);
//        p1.add(l3);
//
//
//        JLabel l4 = new JLabel("Active Now");
//        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
//        l4.setForeground(Color.WHITE);
//        l4.setBounds(110, 35, 100, 20);
//        p1.add(l4);
//
//        Timer t = new Timer(1, new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                if(!typing){
//                    l4.setText("Active Now");
//                }
//            }
//        });
//
//        t.setInitialDelay(2000);
//
//
//        a1 = new JPanel();
//        a1.setBounds(5, 75, 440, 570);
//        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(a1);
//
//
//        t1 = new JTextField();
//        t1.setBounds(5, 655, 310, 40);
//        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        f1.add(t1);
//
//        t1.addKeyListener(new KeyAdapter(){
//            public void keyPressed(KeyEvent ke){
//                l4.setText("typing...");
//
//                t.stop();
//
//                typing = true;
//            }
//
//            public void keyReleased(KeyEvent ke){
//                typing = false;
//
//                if(!t.isRunning()){
//                    t.start();
//                }
//            }
//        });
//
//        b1 = new JButton("Send");
//        b1.setBounds(320, 655, 123, 40);
//        b1.setBackground(new Color(7, 94, 84));
//        b1.setForeground(Color.WHITE);
//        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        b1.addActionListener(this);
//        f1.add(b1);
//
//        f1.getContentPane().setBackground(Color.WHITE);
//        f1.setLayout(null);
//        f1.setSize(450, 700);
//        f1.setLocation(400, 200);
//        f1.setUndecorated(true);
//        f1.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        try{
//            String out = t1.getText();
//
//            JPanel p2 = formatLabel(out);
//
//            a1.setLayout(new BorderLayout());
//
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//
//            a1.add(vertical, BorderLayout.PAGE_START);
//
//            //a1.add(p2);
//            dout.writeUTF(out);
//            t1.setText("");
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public static JPanel formatLabel(String out){
//        JPanel p3 = new JPanel();
//        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
//
//        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
//        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        l1.setBackground(new Color(37, 211, 102));
//        l1.setOpaque(true);
//        l1.setBorder(new EmptyBorder(15,15,15,50));
//
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//        JLabel l2 = new JLabel();
//        l2.setText(sdf.format(cal.getTime()));
//
//        p3.add(l1);
//        p3.add(l2);
//        return p3;
//    }
//
//    public static void main(String[] args){
//        new Server1().f1.setVisible(true);
//
//        String msginput = "";
//        try{
//            skt = new ServerSocket(6001);
//            while(true){
//                s = skt.accept();
//                din = new DataInputStream(s.getInputStream());
//                dout = new DataOutputStream(s.getOutputStream());
//
//                while(true){
//                    msginput = din.readUTF();
//                    JPanel p2 = formatLabel(msginput);
//
//                    JPanel left = new JPanel(new BorderLayout());
//                    left.add(p2, BorderLayout.LINE_START);
//                    vertical.add(left);
//                    f1.validate();
//                }
//
//            }
//
//        }catch(Exception e){}
//    }
//}

//=============================CALLING==========================================================================================//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//class calling extends JFrame {
//
//
//    calling(){
//
//        JPanel p1;
//        JPanel p2;
//        JPanel p3;
//        JTextField t1;
//        JButton b1;
//        JTextArea tf1;
//        JScrollPane sb;
//
//
//            //green navbar
//            p1 = new JPanel();
//            p1.setLayout(null);
//            p1.setBackground(new Color(7, 94, 84));
//            p1.setBounds(0, 0, 400, 70);
//            add(p1);
//
//
//            // exit button - icon no.01
//            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3.png"));
//            Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//            ImageIcon i3 = new ImageIcon(i2);
//            JLabel l1 = new JLabel(i3);
//
//            l1.setBounds(5, 25, 20, 20);
//            p1.add(l1);
//
//            //mouseevent for exit
//            l1.addMouseListener(new MouseAdapter() {
//                public void mouseClicked(MouseEvent ae) {
//                    System.exit(0);
//                }
//            });
//
//
//            // DP - icon no.02
//            ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/elon.png"));
//            Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//            ImageIcon i6 = new ImageIcon(i5);
//            JLabel l2 = new JLabel(i6);
//
//            l2.setBounds(30, 5, 60, 60);
//            p1.add(l2);
//
//            // Video call - icon no.02
//            ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/video.png"));
//            Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//            ImageIcon i9 = new ImageIcon(i8);
//            JLabel l3 = new JLabel(i9);
//
//            l3.setBounds(230, 15, 40, 40);
//            p1.add(l3);
//
//            //Audio call - icon no.03
//            ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/phone.png"));
//            Image i11 = i10.getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT);
//            ImageIcon i12 = new ImageIcon(i11);
//            JLabel l4 = new JLabel(i12);
//
//            l4.setBounds(290, 16, 40, 40);
//            p1.add(l4);
//
//            //More options - icon no.04
//            ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3icon.png"));
//            Image i14 = i13.getImage().getScaledInstance(12, 22, Image.SCALE_DEFAULT);
//            ImageIcon i15 = new ImageIcon(i14);
//            JLabel l5 = new JLabel(i15);
//
//            l5.setBounds(335, 15, 40, 40);
//            p1.add(l5);
//
//
//            //Name - text no.01
//            JLabel l6 = new JLabel("Elon Musk");
//            l6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//            l6.setForeground(Color.WHITE);
//            l6.setBounds(95, 16, 100, 40);
//            p1.add(l6);
//
//
//        p2 = new JPanel();
//        p2.setLayout(null);
//        p2.setBackground(new Color(7, 94, 84));
//        p2.setBounds(0, 510, 430, 100);
//        add(p2);
//
//        ImageIcon i44 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/deline button.png"));
//        Image i55 = i44.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
//        ImageIcon i66 = new ImageIcon(i55);
//        JLabel l22 = new JLabel(i66);
//
//        l22.setBounds(30, 20, 60, 60);
//        p2.add(l22);
//
//        l22.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.exit(0);
//            }
//            public void mousePressed(MouseEvent e) {}
//            public void mouseReleased(MouseEvent e) {}
//            public void mouseEntered(MouseEvent e) {}
//            public void mouseExited(MouseEvent e) {}
//        });
//
//        ImageIcon i45 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/speaker button.png"));
//        Image i56 = i45.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
//        ImageIcon i67 = new ImageIcon(i56);
//        JLabel l23 = new JLabel(i67);
//
//        l23.setBounds(130, 20, 60, 60);
//        p2.add(l23);
//
//        ImageIcon i46 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/mute button.png"));
//        Image i57 = i46.getImage().getScaledInstance(20, 30, Image.SCALE_DEFAULT);
//        ImageIcon i68 = new ImageIcon(i57);
//        JLabel l24 = new JLabel(i68);
//
//        l24.setBounds(215, 20, 60, 60);
//        p2.add(l24);
//
//
//        ImageIcon i47 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/Video Call Mute.png "));
//        Image i58 = i47.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
//        ImageIcon i69 = new ImageIcon(i58);
//        JLabel l25 = new JLabel(i69);
//
//        l25.setBounds(300, 20, 60, 60);
//        p2.add(l25);
//
//        p3 = new JPanel();
//        p3.setLayout(null);
//        p3.setBounds(0, 100, 430, 400);
//        add(p3);
//
//
//        // DP - icon no.02
//        ImageIcon i444 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/elon.png"));
//        Image i555 = i444.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
//        ImageIcon i666 = new ImageIcon(i555);
//        JLabel l222 = new JLabel(i666);
//
//        l222.setBounds(50, 5, 300, 300);
//        p3.add(l222);
//
//
//        JLabel call = new JLabel("Connecting.....");
//        call.setBackground(Color.black);
//        call.setBounds(140,250,200,100);
//        call.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
//        p3.add(call);
//
//        JLabel call1 = new JLabel("Voice call");
//        call1.setBackground(Color.black);
//        call1.setBounds(160,280,200,100);
//        call1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
//        p3.add(call1);
//
//            setLayout(null);
//            //Window box - Server
//            setSize(400, 600);
//            setLocation(200, 70);
//            //for removing the above navbar box
//            setUndecorated(true);
//            setVisible(true);
//        }
//    }
//
//public class Client11{
//    public static void main(String[] args) {
//        calling a = new calling();
//    }
//}
//
////=== === === === === === === BACKED UP MESSAGES === === === === === === === === === === === === === === === === === ===
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//class backup extends JFrame {
//
//    JPanel p1;
//    JTextField t1;
//    JButton b1;
//    static JTextArea tf1;
//    JScrollPane sb;
//    JLabel l5;
//
//
//    public backup() {
//
//        //green navbar
//        p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(7, 94, 84));
//        p1.setBounds(0, 0, 400, 70);
//        add(p1);
//
//        // Download - icon no.02
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/download.png"));
//        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JLabel l2 = new JLabel(i6);
//
//        l2.setBounds(30, 5, 60, 60);
//        p1.add(l2);
//
//        //Name - text no.01
//        JLabel l6 = new JLabel("Backed up messages");
//        l6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        l6.setForeground(Color.WHITE);
//        l6.setBounds(95, 16, 400, 40);
//        p1.add(l6);
//
//
//        //close button
//        b1 = new JButton("Close");
//        b1.setBounds(310, 555, 85, 40);
//        b1.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//        b1.setForeground(Color.white);
//        b1.setBackground(new Color(7, 94, 84));
//        add(b1);
//
//        b1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//        //text field
//        // display area.
//        tf1 = new JTextArea();
//
//        tf1.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
//        tf1.setBackground(Color.white);
//        tf1.setEditable(false);
//        tf1.setLineWrap(true);
//        tf1.setWrapStyleWord(true);
//
//        // adding scroll bar
//        sb = new JScrollPane(tf1);
//        sb.setBounds(5, 75, 390, 475);
//        sb.addNotify();
//        add(sb);
//
//        String BackedData = null;
//        String BackedDate = null;
//        String[] Backed_up = new String[1000];
//
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "1234");
//
//            Statement sts = con.createStatement();
//            ResultSet resultSet = sts.executeQuery("select * from chat_backup");
//
//            while(resultSet.next()){
//                BackedData = resultSet.getString("chats");
//                BackedDate = resultSet.getString("date_chats");
//
//                tf1.setText(tf1.getText()+"\n" + "Text: "+BackedData+" || Date: "+BackedDate);
//            }
//
//            System.out.println(BackedData);
//            System.out.println(BackedDate);
//
//            con.close();
//
//        } catch (Exception ae) {
//            ae.printStackTrace();
//        }
//
//        setLayout(null);
//        //Window box - Server
//        setSize(400, 600);
//        setLocation(250, 90);
//        //for removing the above navbar box
//        setUndecorated(true);
//        setVisible(true);
//    }
//}
//
//public class Client11 {
//    public static void main(String[] args) {
//        backup a = new backup();
//    }
//}




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;



//=== === === === === === CALLING === === === === === === === === === === === === === === === === === === === === ===
class calling_client1 extends JFrame {


    calling_client1(String a){

        JPanel p1;
        JPanel p2;
        JPanel p3;
        JTextField t1;
        JButton b1;
        JTextArea tf1;
        JScrollPane sb;


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
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/astronaut.png"));
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


        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(7, 94, 84));
        p2.setBounds(0, 510, 430, 100);
        add(p2);

        ImageIcon i44 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/deline button.png"));
        Image i55 = i44.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i66 = new ImageIcon(i55);
        JLabel l22 = new JLabel(i66);

        l22.setBounds(30, 20, 60, 60);
        p2.add(l22);

        l22.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        ImageIcon i45 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/speaker button.png"));
        Image i56 = i45.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i67 = new ImageIcon(i56);
        JLabel l23 = new JLabel(i67);

        l23.setBounds(130, 20, 60, 60);
        p2.add(l23);

        ImageIcon i46 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/mute button.png"));
        Image i57 = i46.getImage().getScaledInstance(20, 30, Image.SCALE_DEFAULT);
        ImageIcon i68 = new ImageIcon(i57);
        JLabel l24 = new JLabel(i68);

        l24.setBounds(215, 20, 60, 60);
        p2.add(l24);


        ImageIcon i47 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/Video Call Mute.png "));
        Image i58 = i47.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i69 = new ImageIcon(i58);
        JLabel l25 = new JLabel(i69);

        l25.setBounds(300, 20, 60, 60);
        p2.add(l25);

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(0, 100, 430, 400);
        add(p3);


        // DP - icon no.02
        ImageIcon i444 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/elon.png"));
        Image i555 = i444.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i666 = new ImageIcon(i555);
        JLabel l222 = new JLabel(i666);

        l222.setBounds(50, 5, 300, 300);
        p3.add(l222);


        JLabel call = new JLabel("Connecting.....");
        call.setBackground(Color.black);
        call.setBounds(140,250,200,100);
        call.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        p3.add(call);

        JLabel call1 = new JLabel(a);
        call1.setBackground(Color.black);
        call1.setBounds(160,280,200,100);
        call1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        p3.add(call1);

        setLayout(null);
        setSize(400, 600);
        setLocation(700, 70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }
}


class Error_thrower_client11 extends JFrame{

    JLabel lb1;
    JButton b1;
    JLabel l2;
    JLabel l3;
    JLabel l4;

    public Error_thrower_client11() {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/1.1.png"));
        Image i2 = i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0,0,0,0);
        add(l1);

        l2 = new JLabel("Incorrect");
        l2.setBounds(2,2,150,150);
        l2.setForeground(Color.red);
        l2.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        l2.setLocation(240,208);
        l1.add(l2);

        l3 = new JLabel("Username");
        l3.setBounds(2,2,150,150);
        l3.setForeground(Color.red);
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        l3.setLocation(240,256);
        l1.add(l3);

        l4 = new JLabel("Password");
        l4.setBounds(2,2,150,150);
        l4.setForeground(Color.red);
        l4.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        l4.setLocation(240,305);
        l1.add(l4);


        lb1 = new JLabel("ERROR");
        lb1.setBounds(2,2,300,300);
        lb1.setForeground(Color.red);
        lb1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        lb1.setLocation(227,105);
        l1.add(lb1);


        b1 = new JButton("Close");
        b1.setBounds(213,410, 100, 30);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(7, 94, 84));
        l1.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(450,550);
        setLocation(450,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
}


//===LOGIN FORM === === === === === === === === === === === === === === === === === === === === === === === === ===//
class loginClient1 extends JFrame {
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

    JTextField r;
    JTextField g;
    JTextField b;


    loginClient1() {

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

        t1 = new JTextField("Email bro");
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

                    int x = Integer.parseInt(r.getText());
                    int y = Integer.parseInt(g.getText());
                    int z = Integer.parseInt(b.getText());

                    if (resultSet.next()) {
                        new Client11(x,y,z).setVisible(true);
                        setVisible(false);
                    } else {
                        Error_thrower_client1 etc = new Error_thrower_client1();
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

        r = new JTextField("7");
        r.setBounds(615, 390, 40, 30);
        r.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
        r.setForeground(Color.black);
        bg.add(r);

        g = new JTextField("94");
        g.setBounds(705, 390, 40, 30);
        g.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
        g.setForeground(Color.black);
        bg.add(g);

        b = new JTextField("84");
        b.setBounds(795, 390, 40, 30);
        b.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
        b.setForeground(Color.black);
        bg.add(b);

        setSize(1000, 500);
        setLocation(200, 130);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
//--------------------------------------------------------------------------------------------------------------------------//


class Client11 extends JFrame implements ActionListener {

    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea tf1;
    JScrollPane sb;

    //network
    static Socket s1;
    static DataInputStream din1;
    static DataOutputStream dout1;

    public Client11(int r, int g, int b) {

        //green navbar
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(r, g, b));
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
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/astronaut.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        //9042622676 --> samosa waley

        l2.setBounds(30, 5, 60, 60);
        p1.add(l2);



        // Video call - icon no.02
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l3 = new JLabel(i9);

        l3.setBounds(220, 20, 30, 30);
        p1.add(l3);

        l3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {calling call = new calling("Video call");}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        l3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {calling_client call = new calling_client("Video call");}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        //Audio call - icon no.03
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l4 = new JLabel(i12);

        l4.setBounds(270, 20, 30, 30);
        p1.add(l4);

        l4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {calling_client call = new calling_client("Audio call");}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        l4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {calling call = new calling("Audio call");}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });


        //Backup button - icon no.04
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/Upload.png"));
        Image i14 = i13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l5 = new JLabel(i15);

        l5.setBounds(315, 20, 30, 30);
        p1.add(l5);


        l5.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e){
                try{
                    String data = tf1.getText();
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                    String datestr = formatter.format(date);
                    String sql = "INSERT INTO chat_backup (chats,date_chats) " + "VALUES ('" + data + "','" + datestr + "');";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "1234");

                    Statement sts = con.createStatement();
                    sts.executeUpdate(sql);
                    System.out.println("data entered" + data);
                    con.close();

                }
                catch(Exception ee){
                    ee.printStackTrace();
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e) {}
        });

        //Download button - icon no.04
        ImageIcon i133 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/download.png"));
        Image i144 = i133.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i155 = new ImageIcon(i144);
        JLabel l55 = new JLabel(i155);

        l55.setBounds(360, 20, 30, 30);
        p1.add(l55);

        l55.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backup obj = new backup();
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e) {}
        });

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
        b1.setBackground(new Color(r, g, b));
        b1.addActionListener(this);
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


//        getContentPane().setBackground(Color.yellow);//background color
        setLayout(null);

        //Window box - Server
        setSize(400, 600);
        setLocation(700, 70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }


    // for overriding in action performed for exit
    public void actionPerformed(ActionEvent ae) {

        String out = t1.getText();
        tf1.setText(tf1.getText() + "\n\n\t\t" + out);
        try {
            dout1.writeUTF(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        t1.setText("");

    }

    public static void main(String[] args) {
        loginClient1 lg = new loginClient1();
        String textinput = "";
        try{

            s1= new Socket("127.0.0.1",6000);
            din1 = new DataInputStream(s1.getInputStream());
            dout1 = new DataOutputStream(s1.getOutputStream());

            while(!textinput.equals("Exit")) {
                textinput = din1.readUTF();
                tf1.setText(tf1.getText() + "\n\n  " + textinput);
            }
            s1.close();
        }
        catch(Exception e){e.printStackTrace();}

    }
}