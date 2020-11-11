package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Login extends JFrame {
    private JLabel label1 = new JLabel("Email");
    private JLabel label2 = new JLabel("Mot de passe");
    private JTextField textField1 = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
//    private Icon icon = new ImageIcon("../File/back.png");
//    private JButton button1 = new JButton(new ImageIcon("1.jpg"));
    private JButton button2 = new JButton("Se connecter");
    private URL url = getClass().getClassLoader().getResource("1.jpg");
    private JButton button1 = new JButton(new ImageIcon(url));
    private JPanel panel0 = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    public Login(){
        super("Login");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(initFrame());
        this.pack();
    }

    private Container initFrame() {



        panel0.setLayout(new BorderLayout());
        button1.setSize(new Dimension(20,20));
        button1.setSize(40,40);
        panel0.add(button1,BorderLayout.WEST);

        panel1.setLayout(new GridLayout(2,2,5,5));
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(passwordField);

        panel2.setLayout(new GridLayout(1,1));
        panel2.add(button2);


        panel3.setLayout(new BorderLayout());
        panel3.add(panel0,BorderLayout.NORTH);
        panel3.add(panel1,BorderLayout.CENTER);
        panel3.add(panel2,BorderLayout.SOUTH);
        return panel3;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JPanel getPanel0() {
        return panel0;
    }

    public void setPanel0(JPanel panel0) {
        this.panel0 = panel0;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public void addComponentListener(ActionListener actionListener) {
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }
}
