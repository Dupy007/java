package Model;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    public static Connection connect(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Files/holybible.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
//        System.out.println("Opened database successfully");
        return c;
    }
    public static Connection disconnect(){
        Connection c = null;
        return c;
    }
    public static void res(){
        Connection c = connect();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM bible;" );
            int i =0;
            while ( rs.next() ) {
               /* int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();*/
                System.out.println(rs.getString(4));
//                i++;
            }
            rs.close();
            stmt.close();
            c = disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static ArrayList book(int i){
        Connection c = connect();
        Statement stmt = null;
        String req = "SELECT verse FROM bible WHERE Book='"+i+"';";
        ArrayList arrayList = new ArrayList();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( req );
            while ( rs.next() ) {
                arrayList.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            c = disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return arrayList;
    }
    public static ArrayList book(){
        Connection c = connect();
        Statement stmt = null;
        String req = "SELECT DISTINCT(book) FROM bible;";
        ArrayList arrayList = new ArrayList();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( req );
            while ( rs.next() ) {
                arrayList.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            c = disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return arrayList;
    }
    public static ArrayList all(){
        Connection c = connect();
        Statement stmt = null;
        String req = "SELECT verse FROM bible;";
        ArrayList arrayList = new ArrayList();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( req );
            while ( rs.next() ) {
                arrayList.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            c = disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return arrayList;
    }

    public static void save(String data){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Files/mydata.db");
            // the sqlite create statement
            String query = "CREATE TABLE IF NOT EXISTS Data(valeur TEXT NOT NULL);";

            // insert preparedstatement
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();

            // the sqlite insert statement
            query = "INSERT INTO Data(valeur) values(?);";

            // create the mysql insert preparedstatement
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setString (1, data);


            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("Insert success \n Data={\n"+data+"\n}");
            c=null;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    public static String save(){
        Connection c = null;
        String x=" ";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Files/mydata.db");
            // the sqlite create statement
            String query = "CREATE TABLE IF NOT EXISTS Data(valeur TEXT NOT NULL);";

            // insert preparedstatement
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();


            Statement stmt = null;
            String req = "SELECT valeur FROM Data;";

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( req );
                while ( rs.next() ) {
                    x=(rs.getString(1));
                }
                rs.close();
                stmt.close();
                c = disconnect();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    return x;
    }



}

