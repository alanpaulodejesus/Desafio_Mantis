create database ProjetoDesafiodeCarreira;
use ProjetoDesafiodeCarreira;

create table TokenAcesso(
 gerarToken varchar(30)
);

insert into TokenAcesso (gerarToken) value ('Token de Teste');

select * from TokenAcesso;