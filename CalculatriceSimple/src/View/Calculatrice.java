package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame {
    private JPanel container = new JPanel();
    //Tableau stockant les éléments à afficher dans la calculatrice
    String[] tab_string = {"C","/","*","-","7", "8", "9","+",
                            "4", "5", "6", "=","1", "2", "3", "0"};
    //Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];
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
        Font police = new Font("Arial", Font.BOLD, 20);
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
//            if (i == 7|| i == 14)
//                tab_button[i].setPreferredSize(dimension2);
//            else if (i == 15)
//                tab_button[i].setPreferredSize(dimension3);
//            else
                tab_button[i].setPreferredSize(dimension);

            panel.add(tab_button[i]);
        }


        panlabel.add(label);
        panlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        container.add(panlabel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
}
  
}

