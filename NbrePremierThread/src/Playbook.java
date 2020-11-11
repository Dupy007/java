import java.util.ArrayList;
import java.util.Scanner;

public class Playbook {



    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.println("Bienvenue");

        ArrayList arrayList = new ArrayList();
        int a = 0,b = 0,c = 1;
        do {
            System.out.println("Entrez la premiere valeur");
            a = key.nextInt();
            System.out.println("Entrez la derniere valeur");
            b = key.nextInt();
        }while (a>=b);

        c += (b-a)/10;
        Thread thread[] = new Thread[c];
        Un un[] = new Un[c];
        for (int i = 0; i < c; i++) {

            if ((a+10)<b)
                un[i] = new Un(a,a+10);
            else
                un[i] = new Un(a,b);

            a+=10;

            thread[i] = new Thread(un[i]);
        }
        for (int i = 0; i < c; i++) {
           thread[i].start();
        }
        try {
            for (int i = 0; i < c; i++) {
                thread[i].join();
                arrayList.add(un[i].getTab());
            }
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }
            System.out.print("Le resultat est : [ ");
        for (Object x:arrayList) {
            System.out.print(x+" , ");
        }
        System.out.println(" ]");



    }
    private static class Un implements Runnable {

        private ArrayList<Integer> tab = new ArrayList<Integer>();
        private int a,b;
        public Un( int a, int b ){
            this.a=a;
            this.b=b;
        }

        public void run(){
            this.start();
        }

        public void start() {
            for (int i = a; i < b; i++) {
                if (isPremier(i)) {
                    tab.add(i);
                }
            }
        }

        public boolean isPremier(int n) {
            boolean isPremier = true;
            for (int i = 2; i <= n / 2; i++) {
                if (n != i && n % i == 0) {
                    isPremier = false;
                    break;
                }
            }
            return isPremier;
        }

        public ArrayList<Integer> getTab() {
            return tab;
        }
    }
}
