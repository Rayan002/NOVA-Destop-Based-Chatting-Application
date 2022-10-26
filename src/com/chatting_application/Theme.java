package com.chatting_application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Theme extends JFrame {
    Theme() {

        setSize(400, 500);
        setLocation(520, 120);
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/loginback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0, 0, 450, 550);
        add(l1);



//        String[] com = {"WhatsApp","Telegram","Instagram","Custom"};
//        JComboBox combo = new JComboBox(com);
//        combo.setBounds(300,255,250,30);
//        combo.setBackground(Color.white);
//        l1.add(combo);


    }
    public static void main(String[] args) {
        LoginForm lkn = new LoginForm();
        lkn.b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Theme().setVisible(true);
            }
        });
    }

}
