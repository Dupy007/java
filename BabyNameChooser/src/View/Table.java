package View;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Table extends  JFrame{

    private final Dimension d = new Dimension(920, 460);
    private  final String tab[]= { "","Prenom", " Signification", " Couleur",
            "Caractere", "Numerologie","Genre"};
    private static String data[];
    private String[][] value = { {"test","test","test","test","test","test","test","test"} };
    private JTable carnet = new JTable(value,tab);
    private JScrollPane c = new JScrollPane(carnet);
    private JPanel panel = new JPanel();
    private int nbre;
    private JMenuItem lister = new JMenuItem("Lister par origine");
    private JMenuItem favoris = new JMenuItem("Favoris");
    private JMenuItem recherche = new JMenuItem("Recherche");

    public Table(){
        super("Baby Name");
        this.setSize(d);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setJMenuBar(Menu());

        this.setContentPane(initFrame());
        this.pack();

        this.setLocationRelativeTo(null);
    }

    private Container initFrame() {
//        JLabel label = new JLabel("Bienvenue !!!\n A BabynameChooser nous avons environ "+nbre+" noms d'enfants a vous proposer");
        c.setSize(d);
//        panel.add(label,BorderLayout.NORTH);
        panel.add(c,BorderLayout.CENTER);
        return panel;
    }

    public JMenuBar Menu() {
//		--- Creation menu ---
        JMenuBar menu = new JMenuBar();

//		--- Creation des menus bar ---
        JMenu f = new JMenu("File");
        JMenu a = new JMenu("Help?");

//		--- ajoutation des menus bar ---
        menu.add(f);

//		--- ajoutation des items des menus ---
        f.add(lister);
        f.add(favoris);
        f.addSeparator();
        f.add(recherche);
        return menu;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    public Dimension getD() {
        return d;
    }

    public String[] getTab() {
        return tab;
    }

    public static String[] getData() {
        return data;
    }

    public static void setData(String[] data) {
        Table.data = data;
    }

    public String[][] getValue() {
        return value;
    }

    public void setValue(String[][] value) {
        this.value = value;
    }

    public JTable getCarnet() {
        return carnet;
    }

    public void setCarnet(JTable carnet) {
        this.carnet = carnet;
    }

    public JScrollPane getC() {
        return c;
    }

    public void setC(JScrollPane c) {
        this.c = c;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JMenuItem getLister() {
        return lister;
    }

    public void setLister(JMenuItem lister) {
        this.lister = lister;
    }

    public JMenuItem getFavoris() {
        return favoris;
    }

    public void setFavoris(JMenuItem favoris) {
        this.favoris = favoris;
    }

    public JMenuItem getRecherche() {
        return recherche;
    }

    public void setRecherche(JMenuItem recherche) {
        this.recherche = recherche;
    }

    public void addComponentListener(MouseListener mouseListener) {
        lister.addMouseListener(mouseListener);
        favoris.addMouseListener(mouseListener);
        recherche.addMouseListener(mouseListener);
    }
}
