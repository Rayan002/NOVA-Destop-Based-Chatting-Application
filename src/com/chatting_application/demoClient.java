package com.chatting_application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;


class Error_thrower extends JFrame{

    JLabel lb1;
    JButton b1;

    public Error_thrower() {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/1.1.png"));
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





        setSize(450,550);
        setLocation(450,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);

//        JLabel l1 =  new JLabel("Hello world.");
//        add(l1);// adding this mandatory otherwise it will not be going to appear.


    }
}

public class demoClient extends JFrame implements ActionListener {

    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea tf1;

    //network
    static Socket s1;
    static DataInputStream din1;
    static DataOutputStream dout1;

    public demoClient(){

        //green navbar
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,400,70);
        add(p1);


        // exit button - icon no.01
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(5,25,20,20);
        p1.add(l1);

        //mouseevent for exit
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });


        // DP - icon no.02
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);

        l2.setBounds(30,5,60,60);
        p1.add(l2);

        // Video call - icon no.02
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l3 = new JLabel(i9);

        l3.setBounds(230,15,40,40);
        p1.add(l3);

        //Audio call - icon no.03
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(33,33,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l4 = new JLabel(i12);

        l4.setBounds(290,16,40,40);
        p1.add(l4);

        //More options - icon no.04
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(12,22,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l5 = new JLabel(i15);

        l5.setBounds(335,15,40,40);
        p1.add(l5);


        //Name - text no.01
        JLabel l6 = new JLabel("Elon Musk");
        l6.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        l6.setForeground(Color.WHITE);
        l6.setBounds(95,16,100,40);
        p1.add(l6);

        //send text field
        t1 = new JTextField();
        t1.setBounds(5,555,300,40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(t1);

        //send button
        b1 = new JButton("Send");
        b1.setBounds(310,555,85,40);
        b1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(7,94,84));
        b1.addActionListener(this);
        add(b1);

        //text field -- display area.
        tf1 = new JTextArea();
        tf1.setBounds(5,75,390,475);
        tf1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        tf1.setBackground(Color.white);
        tf1.setEditable(false);
        tf1.setLineWrap(true);
        tf1.setWrapStyleWord(true);
//        tf1.setBorder(b1.getBorder());
        add(tf1);



//        getContentPane().setBackground(Color.yellow);//background color
        setLayout(null);

        //Window box - Server
        setSize(400,600);
        setLocation(700,70);
        //for removing the above navbar box
        setUndecorated(true);
        setVisible(true);
    }


    // for overriding in action performed for exit
    public void actionPerformed(ActionEvent ae){

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
        LoginForm obj = new LoginForm();

        String n  ="name1";
        obj.b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (n == "name1") {
                    CompletableFuture.runAsync(() -> {
                        demoServer ds = new demoServer();
                        ds.openWindow();
                    });
                    obj.setVisible(false);
                }
                else{
                    System.out.println("error");

                }
            }
        });


        boolean error = true;
        //data base connection ====================================================
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "1234");

            Statement sts = con.createStatement();
            ResultSet resultSet = sts.executeQuery("select * from users");  int resultSet1 = sts.executeUpdate("insert into employee values('2',ddd,ddd)");

            String n1 = "name1";
            while (resultSet.next()) {

                if (n1.equals(resultSet.getObject("name"))) {

                    obj.b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (n1 == "name1") {
                                CompletableFuture.runAsync(() -> {
                                    demoClient ds = new demoClient();
//                                    ds.openWindow();
                                });
                                obj.setVisible(false);
                            }
                            else{
                                System.out.println("error");

                            }
                        }
                    });


                    String textinput = "";
                    try {

                        s1 = new Socket("127.0.0.1", 6005);
                        din1 = new DataInputStream(s1.getInputStream());
                        dout1 = new DataOutputStream(s1.getOutputStream());

                        while (!textinput.equals("Exit")) {
                            textinput = din1.readUTF();
                            tf1.setText(tf1.getText() + "\n\n" + textinput);
                        }
                        s1.close();
                    } catch (Exception e) {
                    }
                    error = false;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (error == true) {
//            Error_thrower objerror = new Error_thrower();
        }
    }
}

