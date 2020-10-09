package Model;

import java.util.ArrayList;

public class Operation {
    public static double add(double a ,double b) {
        return a+b;
    }
    public static double sou(double a ,double b) {
        return a-b;
    }
    public static double mul(double a ,double b) {
        return a*b;
    }
    public static double div(double a ,double b) {
        return a/b;
    }
    public static double exp(String a) {
        double val=0;
        try {

            a=a.replace(" ","");


            String [] l =a.split(" ");
            ArrayList<String> ta =new ArrayList<String>();
            for(int i=0;i<l.length;i++) {
                ta.add(l[i]);
            }

            for(int i=0;i<ta.size()-1;i++){
                Double.parseDouble(ta.get(i));
            }

        } catch (Exception e) {
            System.out.println("Erreur");
            System.out.println(e.getMessage());
        }

        try {

            a=a.replace(" ","");
            a=a.replace("+", " + ");
            a=a.replace("-", " - ");
            a=a.replace("*", " * ");
            a=a.replace("/", " / ");


            String [] t =a.split(" ");
            ArrayList<String> tab =new ArrayList<String>();
            for(int i=0;i<t.length;i++) {
                tab.add(t[i]);
            }

            do {
                for(int i=0;i<tab.size();i++){
                    if(tab.get(i).contains("*")) {
                        double re = mul((Double.parseDouble(tab.get(i-1))), (Double.parseDouble(tab.get(i+1))));
                        String te = String.valueOf(re);
                        tab.set(i-1, te);
                        tab.remove(i);
                        tab.remove(i);
                    }else if(tab.get(i).contains("/")) {
                        double re = div((Double.parseDouble(tab.get(i-1))), (Double.parseDouble(tab.get(i+1))));
                        String te = String.valueOf(re);
                        tab.set(i-1, te);
                        tab.remove(i);
                        tab.remove(i);
                    }
                }


            }while(tab.contains("*")||tab.contains("/"));

            do {
                for(int i=0;i<tab.size();i++) {
                    if(tab.get(i).contains("+")) {
                        double re = add((Double.parseDouble(tab.get(i-1))), (Double.parseDouble(tab.get(i+1))));
                        String te = String.valueOf(re);
                        tab.set(i-1, te);
                        tab.remove(i);
                        tab.remove(i);
                    }else if(tab.get(i).contains("-")) {
                        double re = sou((Double.parseDouble(tab.get(i-1))), (Double.parseDouble(tab.get(i+1))));
                        String te = String.valueOf(re);
                        tab.set(i-1, te);
                        tab.remove(i);
                        tab.remove(i);
                    }

                }
            }while(tab.contains("+")||tab.contains("-"));



            for(int i=0;i<tab.size();i++) {
//		System.out.print(k+" = "+tab.get(i));
                val = Double.parseDouble(tab.get(i));
            }
        }catch(NumberFormatException E) {
            System.out.println(E.getMessage());
            System.out.println("Nous autorisons que les operandes et les operateurs");
        }
        return val;
    }
}
