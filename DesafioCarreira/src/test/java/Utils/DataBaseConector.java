package Utils;


import java.sql.*;

public class DataBaseConector {

    static Connection conn = null;
    public static String nomeProjeto;

   public static void  iniciaConexao() {



        String DRIVER="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dataBaseName="BancoNomeProjeto";
        String username="root";
        String password="";


        try{
            Class.forName( DRIVER );

            conn = DriverManager.getConnection( url+dataBaseName );

            System.out.println( "Conexão Com sucesso!" );

            String sqlQuery ="select * from TabelaNomeProjeto";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery( sqlQuery );
            result.next();

            nomeProjeto = result.getString( "nome" );
            System.out.println( nomeProjeto );


        }catch (Exception e){
            System.out.println( "Falha de execução: " + e);
        }



    }

    public static void fecharConexao() throws SQLException {

            if (conn!=null){
                conn.close();
                System.out.println( "Conexão fechada sucesso!" );
            }

    }


}
