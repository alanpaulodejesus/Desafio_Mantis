/*
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final  String URL ="jdbc:mysql://localhost:3306/BancoProjetoDesafio";
    private static final String USER = "root";
    private static final String PASS= "";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName( DRIVER );

            return DriverManager.getConnection( URL, USER, PASS );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException( "Erro de Conexão", e );
        }
    }

    public static Connection createConexao() throws SQLException {
         return getConnection();
    }

    public static void desconectarConexao() throws SQLException {
        getConnection().close();
    }


}
*/