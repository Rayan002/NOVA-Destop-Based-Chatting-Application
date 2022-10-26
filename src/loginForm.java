/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class loginForm extends JDialog {

    private JTextField tfgmail;
    private JPasswordField pfPassword;
    private JButton btnlogin;
    private JButton btncancel;
    private JPanel loginpanel;

    public loginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginpanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //part-01 =============================================

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfgmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

               user= getAutentication(email,password);

               if (user != null){
                   dispose();
               }
               else{
                   JOptionPane.showMessageDialog(loginForm.this,"Email or password Invalid","Try again",JOptionPane.ERROR_MESSAGE);
               }
            }
        });
    }
     public User user;
    private <User1> User1 getAutentication(String email, String password){
          User1 user = null;

        //database connection.
        final String DB_URL = "jdbc:mysql://localhost/mydata?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "1234";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            //queries
            Statement stat = conn.createStatement();
            String sql = "select * from users where email=? and password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            //executing queries.
            ResultSet resultSet  = preparedStatement.executeQuery();






        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public static void main(String[] args) {
        loginForm lg = new loginForm(null);
    }
}
*/

import javax.swing.*;

class loginForm1 extends JFrame{
    loginForm1(){
        setSize(400,600);
        setLocation(200,70);
        //for removing the above navbar box
//        setUndecorated(true);
        setVisible(true);
    }
}



public class loginForm extends JFrame {
    public static void main(String[] args) {
     loginForm1 obj = new loginForm1();
    }
}














