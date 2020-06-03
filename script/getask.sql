Drop database if exists getask;
create database getask;
use getask;
create table endereco (
  idendereco int(11) not null auto_increment,
  cep varchar(255) not null,
  estado varchar(255) not null,
  cidade varchar(255) not null,
  bairro varchar(255) not null,
  numero varchar(255) not null,
  rua varchar(255) not null,
  primary key(idendereco)
);
create table cliente (
  idcliente int(11) not null auto_increment,
  id_endereco int(11) not null,
  nome varchar(255) not null,
  inscricao varchar(45) not null unique,
  ecpf boolean not null,
  ativo boolean not null,
  data_cadastro date not null,
  telefone int(14) not null,
  email varchar(10) not null,
  primary key(idcliente),
  foreign key (id_endereco) references endereco (idendereco)
);
create table profissional (
  idprofissional int(11) not null auto_increment,
  id_endereco int(11) not null,
  nome varchar(255) not null,
  cpf int(14) not null unique,
  telefone int(14) not null,
  email varchar(10) not null,
  data_cadastro date not null,
  ativo boolean not null,
  primary key(idprofissional),
  foreign key (id_endereco) references endereco (idendereco)
 );
create table categoria (
  idcategoria int(11) not null auto_increment,
  nome varchar(255) not null,
  primary key(idcategoria)
  );
  create table profissional_categoria (
   idprofissional_categorias  int(11) not null auto_increment,
   id_categoria int(11) not null,
   id_profissional int(11) not null,
   primary key(idprofissional_categorias),
   foreign key (id_categoria) references  categoria (idcategoria),
   foreign key (id_profissional) references  profissional (idprofissional)
   );  
create table ordem_servico (
  idordem_servico int(11) not null auto_increment,
  id_cliente int(11) not null,
  numero_os varchar(45) not null,
  descricao varchar(255),
  data_cadastro date not null,
  data_inicio date not null,
  data_termino_previsto date not null,
  data_termino date ,
  primary key(idordem_servico),
  foreign key(id_cliente) references cliente (idcliente)
 );
create table ordem_servico_categoria(
	idordem_servico_categoria  int(11) not null auto_increment,
    id_ordem_servico int(11) not null ,
    id_categoria int(11) not null,
	primary key(idordem_servico_categoria),
    foreign key (id_ordem_servico) references  ordem_servico (idordem_servico),
    foreign key (id_categoria) references  categoria (idcategoria)
);
create table ordem_servico_profissional(
	idordem_servico_profissional int(11) not null auto_increment,
	id_ordem_servico int(11) not null ,
	id_profissional int(11) not null,
	primary key(idordem_servico_profissional),
	foreign key (id_ordem_servico) references  ordem_servico (idordem_servico),
	foreign key (id_profissional) references  profissional (idprofissional)
);
    
    
    

