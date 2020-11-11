package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;


public class Register extends JFrame {
    private JLabel label1 = new JLabel("Prenom");
    private JLabel label2 = new JLabel("Nom");
    private JLabel label3 = new JLabel("Sexe");
    private JLabel label4 = new JLabel("Religion");
    private JLabel label5 = new JLabel("Email");
    private JLabel label6 = new JLabel("Mot de passe");
    private JLabel label7 = new JLabel("Statut");

    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField textField3 = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    private String[] sexe = {"Male","Femmelle"};
    private String[] religion = {"Boudisme","Christianisme","Islamique"};
    private String[] statut = {"Couple","Dieu est mon berger"};
    private Icon icon = new ImageIcon("../File/back.png");

    private JComboBox comboBox1 = new JComboBox(sexe);
    private JComboBox comboBox2 = new JComboBox(religion);
    private JComboBox comboBox3 = new JComboBox(statut);

//    private JButton button1 = new JButton();
    private JButton button2 = new JButton("Sauvegarder");
    private URL url = getClass().getClassLoader().getResource("1.jpg");
    private JButton button1 = new JButton(new ImageIcon(url));

    private JPanel panel0 = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    public Register(){
        super("Register");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(initFrame());
        this.pack();
    }

    private Container initFrame() {

        panel0.setLayout(new BorderLayout());
        button1.setSize(16,16);
//        button1.setIcon(new ImageIcon("1.jpg"));
        panel0.add(button1,BorderLayout.WEST);
        panel1.setLayout(new GridLayout(7,2,2,2));
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(label2);
        panel1.add(textField2);
        panel1.add(label3);
        panel1.add(comboBox1);
        panel1.add(label4);
        panel1.add(comboBox2);
        panel1.add(label5);
        panel1.add(textField3);
        panel1.add(label6);
        panel1.add(passwordField);
        panel1.add(label7);
        panel1.add(comboBox3);


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

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JLabel getLabel3() {
        return label3;
    }

    public void setLabel3(JLabel label3) {
        this.label3 = label3;
    }

    public JLabel getLabel4() {
        return label4;
    }

    public void setLabel4(JLabel label4) {
        this.label4 = label4;
    }

    public JLabel getLabel5() {
        return label5;
    }

    public void setLabel5(JLabel label5) {
        this.label5 = label5;
    }

    public JLabel getLabel6() {
        return label6;
    }

    public void setLabel6(JLabel label6) {
        this.label6 = label6;
    }

    public JLabel getLabel7() {
        return label7;
    }

    public void setLabel7(JLabel label7) {
        this.label7 = label7;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public String[] getSexe() {
        return sexe;
    }

    public void setSexe(String[] sexe) {
        this.sexe = sexe;
    }

    public String[] getReligion() {
        return religion;
    }

    public void setReligion(String[] religion) {
        this.religion = religion;
    }

    public String[] getStatut() {
        return statut;
    }

    public void setStatut(String[] statut) {
        this.statut = statut;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public JComboBox getComboBox3() {
        return comboBox3;
    }

    public void setComboBox3(JComboBox comboBox3) {
        this.comboBox3 = comboBox3;
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

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }
    public void addComponentListener(ActionListener actionListener) {
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }
}
