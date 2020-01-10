package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConector {

    public static void  main (String[] args){

        Connection conn = null;

        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dataBaseName="BancoNomeProjeto";
        String username="root";
        String password="alanpaulo2112";

        try{
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            conn = DriverManager.getConnection( url+dataBaseName, username, password);
            //conn = DriverManager.getConnection( url+dataBaseName, username, "" );


            String sqlQuery ="select * from TabelaNomeProjeto";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery( sqlQuery );
            result.next();
            System.out.println( result.getString( "Id: "+"id" ) );
            System.out.println( result.getString( "Nome: "+"nome" ) );

        }catch (Exception e){
            System.out.println( "Aqui" );
        }

        finally {
            if (conn!=null){
                conn=null;
            }
        }
    }
}
