package Controller;

import Model.DAO;
import View.Affichage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayBook {
    public static void main(String[] args) {
        ArrayList arrayList = DAO.book();
        ArrayList arrayList1 = DAO.all();
//        arrayList.add(" ");
        arrayList1.add(" Holly BIBLE ");
        Affichage affichage = null;
        if ((arrayList!=null) && (arrayList1!=null)){
            affichage = new Affichage(arrayList,arrayList1);
            System.out.println("End");
        }
    }
}
