package View;

import Model.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame {
    private JPanel container = new JPanel();
    //Tableau stockant les éléments à afficher dans la calculatrice
    private String[] tab_string = {"C","/","*","-","7", "8", "9","+",
                            "4", "5", "6", "=","1", "2", "3", "0"};
    private String val = "";
    //Un bouton par élément à afficher
    private JButton[] tab_button = new JButton[tab_string.length];
    private JLabel label = new JLabel();
    private Dimension dimension = new Dimension(50, 40);
    private Dimension dimension2 = new Dimension(50, 80);
    private Dimension dimension3 = new Dimension(100, 40);
    private double chiffre1;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";

    public Calculatrice(){
        this.setSize(250, 300);
        this.setTitle("Mini-Calculatrice");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
//On initialise le conteneur avec tous les composants
        initComposant();
//On ajoute le conteneur
        this.setContentPane(container);
        this.setVisible(true);
    }
    private void initComposant(){
//On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.BOLD, 30);
        label = new JLabel("0");
        label.setFont(police);
//On aligne les informations à droite dans le JLabel
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(220, 40));
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(220, 225));

        JPanel panlabel = new JPanel();
        panlabel.setPreferredSize(new Dimension(220, 60));
//On parcourt le tableau initialisé
//afin de créer nos boutons

        for(int i = 0; i < tab_string.length; i++){
            tab_button[i] = new JButton(tab_string[i]);
            if (i == 0) {
                tab_button[i].setPreferredSize(dimension);
                tab_button[i].setForeground(Color.red);
                tab_button[i].addActionListener(new ResetListener());
            }
            else if (i == 11) {
                tab_button[i].setPreferredSize(dimension);
                tab_button[i].addActionListener(new EgalListener());
            }
            else {
                tab_button[i].setPreferredSize(dimension);
                tab_button[i].addActionListener(new ChiffreListener());
            }
                panel.add(tab_button[i]);
        }
        panlabel.add(label);
        panlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        container.add(panlabel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
}
    //Listener affecté au bouton de remise à zéro
    private class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            clicOperateur = false;
            update = true;
            chiffre1 = 0;
            operateur = "";
            label.setText("0");
        }
    }
    private class ChiffreListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
//On affiche le chiffre additionnel dans le label
            String str = ((JButton)e.getSource()).getText();
            if(update){
                update = false;
            }
            else{
                if(!label.getText().equals("0"))
                    str = label.getText() + str;

            }
            val=str;
            label.setText(str);

        }
    }
    private class EgalListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
//On affiche le chiffre additionnel dans le label
            Double x = null;
            if(update){
                update = false;
            }
            else{
                if(!label.getText().equals("0"))
                    x=Operation.exp(val);
            }
            label.setText(String.valueOf(x));

        }
    }
}

