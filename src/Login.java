import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTf;
    JPasswordField pinTf;


    public Login(){
        super("AUTOMATED TELLER MACHINE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
//        setVisible(true);
//        setLocation(350,200);
        //load GUI at the center of the screen
        setLocationRelativeTo(null);

        //make layout manager null to manually position our components within the gui
        setLayout(null);

        //prevent resize
        setResizable(false);

        addGuiComponents();
    }
    public void addGuiComponents(){

        ImageIcon icLg= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));

        //scale image
        Image i = icLg.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon icLogo = new ImageIcon(i);

        JLabel lbLogo = new JLabel(icLogo);
        lbLogo.setBounds(70,10,100,100);
        add(lbLogo);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTf = new JTextField();
        cardTf.setBounds(300,150,230,30);
        cardTf.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTf);


        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(120,220,250,30); // Chỉnh lại vị trí, đổi Y thành 200
        add(pin);


        pinTf = new JPasswordField();
        pinTf.setBounds(300,220,230,30);
        pinTf.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTf);

        login  = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == clear){
            cardTf.setText("");
            pinTf.setText("");
        } else if (ae.getSource() == login){

        } else if (ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }


        public static void main(String[] args)
        {
            new Login().setVisible(true);
        }
}
