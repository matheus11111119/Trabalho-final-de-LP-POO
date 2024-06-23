CREATE DATABASE `pinguinando`;
USE pinguinando;
CREATE TABLE dados_senhas(
id int auto_increment not null primary key,
usuario varchar(45) not null,
email varchar(45) not null,
senha varchar(45) not null,
CPF varchar(45),
CNPJ varchar (45),
data_cadastro DATETIME
);
INSERT INTO dados_senhas (usuario, email, senha, CPF, CNPJ, data_cadastro) values ('teste10','teste.teste10@gmail.com', 'teste10','testcpf10', Null, NOW());

select *from dados_senhas;
truncate table dados_senhas;


