--CREATE DATABASE testdb;


CREATE TABLE Produto (
  id varchar(255) NOT NULL ,
  nome character varying(255),
  marca character varying(255),
  unidade character varying(255),
  quantidadeAdicionada double,
  unidadeEstoque bigint default 0,
  primary key(id)
);