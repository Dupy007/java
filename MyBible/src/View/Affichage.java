package View;

import Model.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class Affichage extends  JFrame{
    ArrayList book = DAO.book();
    ArrayList all  = DAO.all();

    private Dimension dimension = getToolkit().getScreenSize();
    private JButton[] livre = new JButton[book.size()];
    private JLabel[] labels = new JLabel[all.size()];
    private JButton save = new JButton("Save");
    private JTextArea textArea = new JTextArea(DAO.save());

    public Affichage(ArrayList arrayList1,ArrayList arrayList2){
        super("Bible");
        this.setSize(dimension);
        this.setJMenuBar(Menu());
        this.add(panel());
        this.book=arrayList1;
        this.all=arrayList2;

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public JPanel panel(){
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(this.getSize()));
        container.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel.setPreferredSize(new Dimension(this.getSize().width*2/10-10,this.getSize().height));
        panel2.setPreferredSize(new Dimension(this.getSize().width*7/10-10,this.getSize().height*20));
        panel3.setPreferredSize(new Dimension(this.getSize().width*1/10-10,this.getSize().height*20));

        panel.setBackground(new Color(175,175,175,128));
        panel2.setBackground(new Color(226, 226, 226, 255));
        panel3.setBackground(new Color(199, 193, 193, 128));

        JScrollPane jScrollPane = new JScrollPane(panel3);
//        jScrollPane.setPreferredSize(new Dimension(this.getSize().width*1/10,this.getSize().height));

        JScrollPane jScrollPane1 = new JScrollPane(panel2);
//        jScrollPane1.setPreferredSize(new Dimension(this.getSize().width*7/10,this.getSize().height));

        textArea.setPreferredSize(new Dimension(this.getSize().width*2/10-20,this.getSize().height*1/2));
        save.setPreferredSize(new Dimension(this.getSize().width*2/10-20,25));

        panel.add(textArea,BorderLayout.NORTH);
        panel.add(save,BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO.save(textArea.getText());

            }
        });

        for (int i = 0; i < book.size(); i++) {
            livre[i] = new JButton((String) book.get(i));
            livre[i].setPreferredSize(new Dimension(this.getSize().width*1/10-50,20));
            int finalI = i;
            int c=this.getSize().width;
            livre[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    all=DAO.book(finalI);
                    for (Object x : all) {
                        System.out.println((String) x);
                    }
                        panel2.removeAll();
                    for (int i = 0; i < all.size(); i++) {
                        labels[i] = new JLabel((String) all.get(i));
                        labels[i].setPreferredSize(new Dimension(c*7/10-20,40));
                        panel2.add(labels[i]);
                        panel2.repaint();
                    }
//
                }
            });
            panel3.add(livre[i]);
            panel3.repaint();
        }
        for (int i = 0; i < all.size(); i++) {
            labels[i] = new JLabel((String) all.get(i));
            labels[i].setPreferredSize(new Dimension(this.getSize().width*7/10-50,40));
            panel2.add(labels[i]);
            panel2.repaint();
        }

        container.add(panel,BorderLayout.WEST);
        container.add(jScrollPane1,BorderLayout.CENTER);
        container.add(jScrollPane,BorderLayout.EAST);
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

    public JButton[] getLivre() {
        return livre;
    }

    public void setLivre(JButton[] livre) {
        this.livre = livre;
    }

}
