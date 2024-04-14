import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTf, emailTf, addressTf, cityTf, stateTf, pinTf;
    JButton next;
    JRadioButton male, female;

    JDateChooser dateChooser;

    public SignUpOne() {

        getContentPane().setBackground(Color.white);
        setTitle("Sign Up Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 750);
        //setLocationRelativeTo(null);
        setLocation(350,10);
        //make layout manager null to manually position our components within the gui
        setLayout(null);

        //prevent resize
        setResizable(false);
        addGuiComponents();
    }

    public void addGuiComponents(){
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " +random );
        formno.setFont(new Font("Railway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetail = new JLabel("Page 1: Personal Details");
        personDetail.setFont(new Font("Railway", Font.BOLD, 22));
        personDetail.setBounds(290,80,400,30);
        add(personDetail);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100,190,100,30);
        add(name);

        nameTf = new JTextField();
        nameTf.setFont(new Font("Railway", Font.BOLD , 14));
        nameTf.setBounds(300,190,400,30);
        add(nameTf);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100,240,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 240,100,50);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 240,100,50);
        female.setBackground(Color.white);
        add(female);

        JLabel birth = new JLabel("Day of birth: ");
        birth.setFont(new Font("Railway", Font.BOLD, 20));
        birth.setBounds(100,290,200,30);
        add(birth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,290,200,30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTf = new JTextField();
        emailTf.setFont(new Font("Railway", Font.BOLD , 14));
        emailTf.setBounds(300,340,400,30);
        add(emailTf);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100,390,200,30);
        add(address);

        addressTf = new JTextField();
        addressTf.setFont(new Font("Railway", Font.BOLD , 14));
        addressTf.setBounds(300,390,400,30);
        add(addressTf);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100,440,200,30);
        add(city);

        cityTf = new JTextField();
        cityTf.setFont(new Font("Railway", Font.BOLD , 14));
        cityTf.setBounds(300,440,400,30);
        add(cityTf);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100,490,200,30);
        add(state);

        stateTf = new JTextField();
        stateTf.setFont(new Font("Railway", Font.BOLD , 14));
        stateTf.setBounds(300,490,400,30);
        add(stateTf);

        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Railway", Font.BOLD, 20));
        pin.setBounds(100,540,200,30);
        add(pin);

        pinTf = new JTextField();
        pinTf.setFont(new Font("Railway", Font.BOLD , 14));
        pinTf.setBounds(300,540,400,30);
        add(pinTf);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway", Font.BOLD,14));
        next.setBounds(600, 590,80,30);
        next.addActionListener(this);
        add(next);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;//long
        String name = nameTf.getText();
        String city = cityTf.getText();
        String state = stateTf.getText();
        String birth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String address = addressTf.getText();
        String email = emailTf.getText();
        String pin = pinTf.getText();

        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected())
        {
            gender = "Female";
        }

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required!");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+city+"','"+state+"','"+birth+"','"+address+"','"+email+"','"+gender+"','"+pin+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

//    public static void main(String[] args){
//
//        new SignUpOne().setVisible(true);
//    }
}
