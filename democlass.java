

class login extends JFrame{
    public void mess(){
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


    LoginForm(){

        p1 = new JPanel();
        p1.setBounds(0,0,1000,500);
        p1.setBackground(new Color(7,94,84));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting_application/icons/loginback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0,0,1000,500);
        p1.add(bg);

        l1 = new JLabel("Login Form");
        l1.setBounds(645,-190,1000,500);
        l1.setFont(new Font("SANS_SERIF",Font.BOLD,28));
        l1.setForeground(Color.white);
        bg.add(l1);


        l2 = new JLabel("Email:");
        l2.setBounds(600,-130,1000,500);
        l2.setFont(new Font("SANS_SERIF",Font.BOLD,18));
        l2.setForeground(Color.white);
        bg.add(l2);

        t1 = new JTextField("Email");
        t1.setBounds(600,150,250,30);
        t1.setFont(new Font("SANS_SERIF",Font.ITALIC,15));
        t1.setForeground(Color.black);
        bg.add(t1);


        l3 = new JLabel("Password:");
        l3.setBounds(600,-25,1000,500);
        l3.setFont(new Font("SANS_SERIF",Font.BOLD,18));
        l3.setForeground(Color.white);
        bg.add(l3);


        t2 = new JPasswordField("Password");
        t2.setBounds(600,255,250,30);
        t2.setFont(new Font("SANS_SERIF",Font.ITALIC,15));
        t2.setForeground(Color.black);
        bg.add(t2);


        b1 =  new JButton("LogIn");
        b1.setBounds(615,320,100,30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        bg.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Theme obj = new Theme(); //creating object of theme to select what theme user want.
//                obj.setVisible(true);
//                setVisible(false); // to remove the login page visibility.

            }
        });

        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent ae) {
                b1.setBackground(new Color(58,111,89));
            }

            @Override
            public void mouseExited(MouseEvent ae) {
                b1.setBackground(Color.white);
            }
        });


        b2 =  new JButton("Cancel");
        b2.setBounds(735,320,100,30);
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        bg.add(b2);

        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(new Color(58,111,89));
            }
            public void mouseExited(MouseEvent e) {
                b2.setBackground(Color.white);
            }
        });


        l4 = new JLabel("N🌖VA");
        l4.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,70));
        l4.setBounds(200,-80,500,500);
        l4.setForeground(Color.white);
        bg.add(l4);

        l5 = new JLabel("Chatting");
        l5.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
        l5.setBounds(200,-0,500,500);
        l5.setForeground(Color.white);
        bg.add(l5);

        l6 = new JLabel("App");
        l6.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
        l6.setBounds(200,25,500,500);
        l6.setForeground(Color.white);
        bg.add(l6);

        setSize(1000,500);
        setLocation(200,130);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public boolean value(){
        boolean n = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "1234");

            Statement sts = con.createStatement();
            ResultSet resultSet = sts.executeQuery("select * from users");
            System.out.println(resultSet);
            String n1 = t1.getText();


            while (resultSet.next()) {
                if (n1.equals(resultSet.getObject("name"))){
                    n = true;
                }
                else {
                    n = false;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(n == true){
            return  true;
        }
        else {
            return false;
        }
    }
    public String name(){

        String name =t1.getText();
        return  name;
    }

}



public class democlass {
    login a = new login();
}
