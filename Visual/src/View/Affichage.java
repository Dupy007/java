package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class Affichage extends  JFrame{
    private Dimension dimension = getToolkit().getScreenSize();
    public Affichage(){
        super("Code");
        this.setSize(dimension);
        this.setJMenuBar(Menu());
        this.add(panel());

        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public JPanel panel(){
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(this.getSize()));
        container.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setPreferredSize(new Dimension(this.getSize().width*2/10,this.getSize().height));
        panel2.setPreferredSize(new Dimension(this.getSize().width*8/10,this.getSize().height));
        panel.setBackground(new Color(175,175,175));
        panel2.setBackground(new Color(74, 74, 74));
        container.add(panel,BorderLayout.WEST);
        container.add(panel2,BorderLayout.CENTER);
        return container ;
    }

    public JMenuBar Menu() {
//		--- Creation menu ---
        JMenuBar menu = new JMenuBar();

//		--- Creation des menus bar ---
        JMenu f = new JMenu("File");
        JMenu a = new JMenu("Help?");

//		--- Creation des items des menus ---
        JMenuItem ne = new JMenuItem("New");
        JMenuItem ex = new JMenuItem("Exit");
        JMenuItem ab = new JMenuItem("About");
//		--- Evenement ---

        ex.addMouseListener( new MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
            dispose();
            };
        } );


//		--- ajoutation des menus bar ---
        menu.add(f);
        menu.add(a);

//		--- ajoutation des items des menus ---
        f.add(ne);
        f.addSeparator();
        f.add(ex);
        a.add(ab);

        return menu;

    }
}
