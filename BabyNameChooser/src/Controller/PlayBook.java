package Controller;

import Model.DAO;
import View.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class PlayBook {
    public static void main(String[] args) {
        Login login= new Login();
        Register register = new Register();
        Home home = new Home();
        Table table = new Table();
        Detail detail = new Detail();
        DAO dao = new DAO();
        String tab[]= { "","Prenom", " Signification", " Couleur",
                "Caractere", "Numerologie","Genre"};
        home.setVisible(true);
//        table.setVisible(true);
        home.addComponentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button =(JButton) actionEvent.getSource();
                if (button==home.getButton1()){
                    home.setVisible(false);
                    login.setVisible(true);
                    login.setLocationRelativeTo(home);
                }else if (button==home.getButton2()){
                    home.setVisible(false);
                    register.setVisible(true);
                    register.setLocationRelativeTo(home);
                }
            }
        });
        login.addComponentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button =(JButton) actionEvent.getSource();
                if (button==login.getButton1()){
                    login.setVisible(false);
                    home.setVisible(true);
                }else if (button==login.getButton2()){
                    if(login.getLabel1().getText().equals("") || login.getPasswordField().getText().equals("")  ){
                        JOptionPane.showMessageDialog(login, "Certains champs sont vides", "Error", 1);
                    }else {
                        login.setVisible(false);
                        dao.ori();
                        table.setCarnet(new JTable(dao.getV(),tab));
                        table.setVisible(true);

                    }

                }
            }
        });
        register.addComponentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button =(JButton) actionEvent.getSource();
                if (button==register.getButton1()){
                    register.setVisible(false);
                    home.setVisible(true);
                }else if (button==register.getButton2()){
                    register.setVisible(false);
                }
            }
        });
        ListSelectionModel cellSelectionModel = table.getCarnet().getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int column = 0;
                int row = table.getCarnet().getSelectedRow();
                String value = table.getCarnet().getModel().getValueAt(row, column+1).toString()+" "+table.getCarnet().getModel().getValueAt(row, column).toString();

                String[] data = new String[7];
                for (int i = 0; i < data.length; i++) {
                    data[i] = table.getCarnet().getModel().getValueAt(row, i).toString();
                }
                 detail.aff(table, value);

            }
        });
        table.addComponentListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                if (menuItem == table.getFavoris()){

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        detail.addComponentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button =(JButton) actionEvent.getSource();
                if (button == detail.getLabel()){
                    detail.getLabel().setVisible(false);
                    detail.getLabel2().setVisible(true);
                }
                if (button == detail.getLabel2()){
                    detail.getLabel2().setVisible(false);
                    detail.getLabel().setVisible(true);
                }
            }
        });


    }
}
