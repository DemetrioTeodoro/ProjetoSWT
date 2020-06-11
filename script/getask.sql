Drop database if exists getask;
create database getask;
use getask;
create table endereco (
  id int(11) not null auto_increment,
  cep varchar(9) not null,
  estado varchar(2) not null,
  cidade varchar(100) not null,
  bairro varchar(100) not null,
  numero varchar(45) not null,
  rua varchar(150) not null,
  primary key(id)
);
create table cliente (
  id int(11) not null auto_increment,
  id_endereco int(11) not null,
  nome varchar(100) not null,
  inscricao varchar(18) not null unique,
  ecpf boolean not null,
  ativo boolean not null,
  data_cadastro date not null,
  telefone int(14) not null,
  email varchar(100) not null,
  primary key(id),
  foreign key (id_endereco) references endereco (id)
);
create table profissional (
  id int(11) not null auto_increment,
  id_endereco int(11) not null,
  nome varchar(100) not null,
  cpf int(14) not null unique,
  telefone int(14) not null,
  email varchar(10) not null,
  data_cadastro date not null,
  ativo boolean not null,
  primary key(id),
  foreign key (id_endereco) references endereco (id)
 );
create table categoria (
  id int(11) not null auto_increment,
  nome varchar(45) not null,
  primary key(id)
  );
  create table profissional_categoria (
   id  int(11) not null auto_increment,
   id_categoria int(11) not null,
   id_profissional int(11) not null,
   primary key(id),
   foreign key (id_categoria) references  categoria (id),
   foreign key (id_profissional) references  profissional (id)
   );  
create table ordem_servico (
  id int(11) not null auto_increment,
  id_cliente int(11) not null,
  id_endereco int(11) not null,
  numero_os varchar(45) not null,
  descricao varchar(255),
  data_cadastro date not null,
  data_inicio date not null,
  data_termino_previsto date not null,
  data_termino date ,
  primary key(idordem_servico),
  foreign key(id_cliente) references cliente (id),
  foreign key(id_endereco) references endereco (id)
 );
create table ordem_servico_categoria(
	id  int(11) not null auto_increment,
    id_ordem_servico int(11) not null ,
    id_categoria int(11) not null,
	primary key(id),
    foreign key (id_ordem_servico) references  ordem_servico (id),
    foreign key (id_categoria) references  categoria (id)
);
create table ordem_servico_profissional(
	id int(11) not null auto_increment,
	id_ordem_servico int(11) not null ,
	id_profissional int(11) not null,
	primary key(id),
	foreign key (id_ordem_servico) references  ordem_servico (id),
	foreign key (id_profissional) references  profissional (id)
);
    
    
    

