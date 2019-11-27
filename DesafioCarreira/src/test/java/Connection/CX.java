/*
package Connection;

import java.sql.Connection;
import java.sql.SQLException;


public class CX {

    static Connection con =null;

    public static void main(String [] args) throws SQLException {

        con= Conexao.createConexao();

        System.out.println( con );

    }
}


PARA O GET NO BANCO


create database ProjetoDesafiodeCarreira;
use ProjetoDesafiodeCarreira;

create table TokenAcesso(
 gerarToken varchar(30)
);

insert into TokenAcesso (gerarToken) value ('Token de Teste');

select * from TokenAcesso;

DROP TABLE TokenAcesso;

*/