CREATE database GERENCIAMENTO;
USE GERENCIAMENTO;

CREATE TABLE Cliente(
 ID INT PRIMARY KEY AUTO_INCREMENT,
 nomeCliente varchar(30) NOT NULL,
 nomeProduto varchar(30) NOT NULL,
 dataCompra date NOT NULL,
 valorProduto numeric(5,2) NOT NULL
);

CREATE TABLE Produto(
 ID INT PRIMARY KEY AUTO_INCREMENT,
 nomeProduto varchar(100) NOT NULL,
 qtddProduto INT NOT NULL,
 dataEntrada date NOT NULL,
 valor numeric(5,2 NOT NULL
);

select*FROM Cliente;

insert INTO Cliente(ID, nomeCliente, nomeProduto, dataCompra, valorProduto)
values(1, "MARIA", "PULSEIRA", '23/11/02', 10);
