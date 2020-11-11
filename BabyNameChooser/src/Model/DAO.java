package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DAO {

    private String cred = "jdbc:mysql://127.0.0.1:3306/babyname?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con = null;
    private Statement stat;
    private ResultSet res;
    private String [][] v;
    private String [][] r;
    private String [] vv;
    private String [] vvv;
    private String resultat;

    public void ajou(ResultSet res,int val) {
        try {
            v[val][0]=res.getString(0);
            v[val][1]=res.getString(1);
            v[val][2]=res.getString(2);
            v[val][3]=res.getString(3);
            v[val][4]=res.getString(4);
            v[val][5]=res.getString(5);
            v[val][6]=res.getString(6);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void ajout(ResultSet res) {
        try {
            vv [0]=(res.getString(0));
            vv [1]=(res.getString(1));
            vv [2]=(res.getString(2));
            vv [3]=(res.getString(3));
            vv [4]=(res.getString(4));
            vv [5]=(res.getString(5));
            vv [6]=(res.getString(6));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void ajoute(ResultSet res,int val) {
        try {
            v[val][0]=(res.getString(0));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ResultSet res(String sqlReq) {
        try {
//			new driver :com.mysql.cj.jdbc.Driver
//			old driver :com.mysql.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con= DriverManager.getConnection(cred,"test","test");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            stat= con.createStatement();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        try{
            res= stat.executeQuery(sqlReq);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int x() {
        int x=0;
        try {
            while(res.next()) {
                x++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public void recherche(String y) {
        String sqlReq = " select prenom,signification,couleur,caractere,numerologie,genre,nomorigine from enfant,origine where enfant.idorigine = origine.idorigine and enfant.prenom="+y+";";

        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][7];
        try {
            while(res.next()) {
                ajou(res, val);
                val++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void ori() {
        String sqlReq = " select prenom,signification,couleur,caractere,numerologie,genre,nomorigine from enfant,origine where enfant.idorigine = origine.idorigine;";

        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][7];
        try {
            while(res.next()) {

                ajou(res, val);
                val++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void numberchild(){
        String sqlReq = " select count(idenfant) as id from enfant;";
        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][7];
        try {
            while(res.next()) {
                resultat=res.getString(0);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherparorigine(String origine){
        String sqlReq = " select prenom,signification,couleur,caractere,numerologie,genre,nomorigine from enfant,origine where origine.nomorigine="+origine+" enfant.idorigine = origine.idorigine;";

        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][7];
        try {
            while(res.next()) {

                ajou(res, val);
                val++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void listeorigine (){
        String sqlReq = " select nomorigine from origine;";

        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][1];
        try {
            while(res.next()) {

                ajou(res, val);
                val++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void  enfantparparent(){
        String sqlReq = " select prenom,signification,couleur,caractere,numerologie,genre,nomorigine from enfant,origine where enfant.idenfant = personneenfant.idenfant and personne.idpersonne=personneenfnat.idpersonne;";

        res = res(sqlReq);

        int val = 0;

        int x = 0;


        try {
            res.last();
            x = res.getRow();
            res.beforeFirst();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        v= new String[x][7];
        try {
            while(res.next()) { 
                ajou(res, val);
                val++;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void enregistrerparent(String nom,String prenom, String sexe, String email, String password, String statut, String religion, String emailconjoint, String cle ){
        String sqlReq = "insert into personne (nom,prenom,sexe,email,password,statut,religion,emailconjoint,cle) values (?,?,?,?,?,?,?,?,?);";

        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://127.0.0.1:3306/babyname?serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "test", "test");

            // the mysql insert statement
            String query =  "insert into personne (nom,prenom,sexe,email,password,statut,religion,emailconjoint,cle) values (?,?,?,?,?,?,?,?,?);";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, nom);
            preparedStmt.setString (2, prenom);
            preparedStmt.setString(3, sexe);
            preparedStmt.setString(4, email);
            preparedStmt.setString (1, password);
            preparedStmt.setString (2, statut);
            preparedStmt.setString(3, religion);
            preparedStmt.setString(4, emailconjoint);
            preparedStmt.setString (1, cle);



            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public String getCred() {
        return cred;
    }

    public void setCred(String cred) {
        this.cred = cred;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStat() {
        return stat;
    }

    public void setStat(Statement stat) {
        this.stat = stat;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public String[][] getV() {
        return v;
    }

    public void setV(String[][] v) {
        this.v = v;
    }

    public String[][] getR() {
        return r;
    }

    public void setR(String[][] r) {
        this.r = r;
    }

    public String[] getVv() {
        return vv;
    }

    public void setVv(String[] vv) {
        this.vv = vv;
    }

    public String[] getVvv() {
        return vvv;
    }

    public void setVvv(String[] vvv) {
        this.vvv = vvv;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
