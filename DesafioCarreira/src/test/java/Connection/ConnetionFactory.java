package Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnetionFactory {

    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final  String URL ="jdbc:mysql://localhost:3306/ProjetoDesafiodeCarreira";
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

    public static  void closeConnection(Connection con)  {
        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            Logger.getLogger(ConnetionFactory.class.getName()).log( Level.SEVERE, null, e );
        }
    }

    public static  void closeConnection(Connection con, PreparedStatement smt)  {

        closeConnection( con );
        try{
            if(smt != null){
                smt.close();
            }
        }catch (SQLException e){
            Logger.getLogger(ConnetionFactory.class.getName()).log( Level.SEVERE, null, e );
        }
    }

    public static  void closeConnection(Connection con, PreparedStatement smt, ResultSet rs)  {

        closeConnection( con , smt);
        try{
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){
            Logger.getLogger(ConnetionFactory.class.getName()).log( Level.SEVERE, null, e );
        }
    }

    public static void main(String [] args) throws SQLException {

        getConnection();
    }
}
