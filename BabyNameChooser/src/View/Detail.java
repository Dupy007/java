package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class Detail extends JFrame {
    private String[] Afficher = {"test","test","test","test","test","test","test"};
    private JButton fermer = new JButton( "Fermer" );
    private JButton aimer = new JButton( "Aimer" );
    private URL url = getClass().getClassLoader().getResource("2.png");
    private URL url2 = getClass().getClassLoader().getResource("3.png");
    private JButton label = new JButton(new ImageIcon(url));
    private JButton label2 = new JButton(new ImageIcon(url2));


    public void aff(Frame owner , String value){

        // --- Récupération du content pane ---
        JPanel contentPane = (JPanel) getContentPane();

        // --- Création de la partie du haut ---
        JPanel Info = new JPanel( new GridLayout( 7, 2, 3, 2 ) );
        Info.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

//       --- creation des label et ajout des champ d'entree ---
        Info.add( new JLabel( "Pr\u00E9nom: " ) );
        Info.add( new JLabel( Afficher[0] ) );
        Info.add( new JLabel( "Signification: " ) );
        Info.add( new JLabel( Afficher[1] ) );
        Info.add( new JLabel( "Couleur: " ) );
        Info.add( new JLabel( Afficher[2] ) );
        Info.add( new JLabel( "Sexe: " ) );
        Info.add( new JLabel( Afficher[3] ) );
        Info.add( new JLabel( "Numerologie: " ) );
        Info.add( new JLabel( Afficher[4] ) );
        Info.add( new JLabel( "Caractere: " ) );
        Info.add( new JLabel( Afficher[5] ) );
        Info.add( new JLabel( "Origine: " ) );
        Info.add( new JLabel( Afficher[6] ) );


        contentPane.add( Info, BorderLayout.CENTER );
        label.setSize(40,40);

//        label.disable();
//        label2.disable();
        JPanel like = new JPanel( new GridLayout(2,2) );

        like.add( label);
        like.add( label2);
        contentPane.add(like,BorderLayout.EAST);



        // --- Création de barre de boutons du bas ---
        JPanel pnlButtons = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );


        pnlButtons.add(fermer);
        contentPane.add( pnlButtons, BorderLayout.SOUTH );


        // --- Affiche la fenêtre ---
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 400, 300 );
        this.setLocationRelativeTo( owner );
        this.setVisible(true);
    }

    public JButton getFermer() {
        return fermer;
    }

    public void setFermer(JButton fermer) {
        this.fermer = fermer;
    }

    public JButton getAimer() {
        return aimer;
    }

    public void setAimer(JButton aimer) {
        this.aimer = aimer;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrl2() {
        return url2;
    }

    public void setUrl2(URL url2) {
        this.url2 = url2;
    }

    public JButton getLabel() {
        return label;
    }

    public void setLabel(JButton label) {
        this.label = label;
    }

    public JButton getLabel2() {
        return label2;
    }

    public void setLabel2(JButton label2) {
        this.label2 = label2;
    }

    public void addComponentListener(ActionListener actionListener) {
        label.addActionListener(actionListener);
        label2.addActionListener(actionListener);
    }
}
