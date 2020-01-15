package DataBaseConector;


import java.sql.*;

public class DataBaseConector {

    static Connection conn = null;
    public static String dadoBanco;

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

        }catch (Exception e){
            System.out.println( "Falha de execução: " + e);
        }

    }

    public static void pesquisaBanco(String acao,String dadoBco, String coluna) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(acao);
        result.next();

        dadoBanco = result.getString( coluna );
        dadoBco = dadoBanco;
        System.out.println( dadoBanco );
    }

    public static void fecharConexao() throws SQLException {

            if (conn!=null){
                conn.close();
                System.out.println( "Conexão fechada sucesso!" );
            }

    }


}
