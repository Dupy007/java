package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JButton button1 = new JButton("Se Connecter");
    private JButton button2 = new JButton("Enregistrer");
    private JPanel panel1 = new JPanel();
    private Dimension dimension = new Dimension(200,200);

    public Home(){
        super("Home");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(initFrame());
        this.pack();
        this.setLocationRelativeTo(null);
//        this.setVisible(true);
    }
    private Container initFrame() {

        panel1.setSize(dimension);
        panel1.setLayout(new BorderLayout());
        panel1.add(button1,BorderLayout.NORTH);
        panel1.add(button2,BorderLayout.SOUTH);

        return panel1;
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

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public void addComponentListener(ActionListener actionListener) {
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }
}
