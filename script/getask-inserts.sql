INSERT INTO CATEGORIA (nome) VALUES ('Azulejista');
INSERT INTO CATEGORIA (nome) VALUES ('Carpinteiro');
INSERT INTO CATEGORIA (nome) VALUES ('Eletricista');
INSERT INTO CATEGORIA (nome) VALUES ('Encanador');
INSERT INTO CATEGORIA (nome) VALUES ('Gesseiro');
INSERT INTO CATEGORIA (nome) VALUES ('Marceneiro');
INSERT INTO CATEGORIA (nome) VALUES ('Pedreiro');
INSERT INTO CATEGORIA (nome) VALUES ('Pintor');
INSERT INTO CATEGORIA (nome) VALUES ('Servente');

INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88025-228' , 'SC', 'Florianópolis', 'Agronomica', '250', 'Servidão Santo Antônio');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88053-361' , 'SC', 'Florianópolis', 'Jurerê Internacional', '240', 'Passagem dos Xaréus');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88065-290' , 'SC', 'Florianópolis', 'Campeche', '210', 'Rua Ilha Sul');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88332-050' , 'SC', 'Balneário Camboriú', 'Barra', '2250', 'Rua Fermino Taveira Cruz');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88330-971' , 'SC', 'Balneário Camboriú', 'Centro', '150', 'Rua 600 1050');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88336-140' , 'SC', 'Balneário Camboriú', 'Nova Esperança', '1500', 'Rua José Francisco Corrêa');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88122-435' , 'SC', 'São José', 'Sertão do Maruim', '15', 'Rua José Martins Neto');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88107-386' , 'SC', 'São José', 'Forquilhas', '115', 'Rua Barcellos');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88115-360' , 'SC', 'São José', 'Serraria', '115', 'Rua Itália');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88168-622' , 'SC', 'Biguaçu', 'Cachoeiras (Guaporanga)', '115', 'Rua Sebastião Albino');
INSERT INTO ENDERECO (cep, estado, cidade, bairro, numero, rua) 
VALUES ('88161-594' , 'SC', 'Biguaçu', 'Rio Caveiras', '115', 'Rua Natalício Vieira');

INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (1, 'Joao Maria Rodrigues', '790.877.690-67', 1, 1, '2018-04-24', '48999512478', 'jm@hotmail.com');
INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (2, 'Maria Rodrigues dos Santos', '041.877.690-09', 1, 1, '2018-02-02', '48988512478', 'mr@hotmail.com');
INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (3, 'Rodrigo Amarantes', '580.877.090-67', 1, 1, '2019-05-24', '48999999999', 'ra@hotmail.com');
INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (4, 'Maria-Mole LTDA', '85.720.164/0001-46', 0, 1, '2018-03-12', '4833334595', 'mm@hotmail.com');
INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (5, 'Mecanica Jesus LTDA', '15.020.122/0001-55', 0, 1, '2020-01-31', '4833345500', 'mj@hotmail.com'); 
INSERT INTO CLIENTE (id_endereco, nome, inscricao, ecpf, ativo, data_cadastro, telefone, email)  
VALUES (6, 'CruxCredo Salão de Beleza', '78.021.232/0001-89', 0, 0, '2020-02-10', '4833345580', 'cc@hotmail.com');            

INSERT INTO PROFISSIONAL (id_endereco, nome, cpf,  telefone, email, data_cadastro, ativo)  
VALUES (7, 'Reginaldo Antunes', '390.876.691-77', '48999912488', 'ra@hotmail.com' , '2018-04-24', 1);
INSERT INTO PROFISSIONAL (id_endereco, nome, cpf,  telefone, email, data_cadastro, ativo)  
VALUES (8, 'Antônio Torttato', '090.576.600-78', '48988812489', 'at@hotmail.com' , '2018-06-24', 1);
INSERT INTO PROFISSIONAL (id_endereco, nome, cpf,  telefone, email, data_cadastro, ativo)  
VALUES (9, 'Agnes Regina Mechellin', '049.976.691-22', '48998812488', 'arg@hotmail.com' , '2019-04-04', 1);
INSERT INTO PROFISSIONAL (id_endereco, nome, cpf,  telefone, email, data_cadastro, ativo)  
VALUES (10, 'Michelli Laurenetty', '041.059.691-25', '48988810088', 'ml@hotmail.com' , '2020-06-04', 1);
INSERT INTO PROFISSIONAL (id_endereco, nome, cpf,  telefone, email, data_cadastro, ativo)  
VALUES (11, 'Laureano Martins', '041.050.690-05', '48988814448', 'lma@hotmail.com' , '2020-05-07', 1);

INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (1 , 1);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (1 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (1 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (2 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (2 , 5);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (2 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (3 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (3 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (3 , 4);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (4 , 5);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (4 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (4 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (5 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (5 , 5);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (5 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (6 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (6 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (6 , 4);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (7 , 2);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (8 , 3);
INSERT INTO PROFISSIONAL_CATEGORIA (id_categoria, id_profissional) VALUES (9 , 4);

INSERT INTO ORDEM_SERVICO (id_cliente, id_endereco, numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto, data_termino)  
VALUES (1, 1, '01478/2020', 'Reforma cozinha', '2020-03-05','2020-04-05','2020-05-25', '2020-05-25');
INSERT INTO ORDEM_SERVICO (id_cliente, id_endereco, numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto)   
VALUES (2, 2, '01479/2020', 'Reforma geral', '2020-04-05','2020-05-31','2020-07-25');
INSERT INTO ORDEM_SERVICO (id_cliente, id_endereco, numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto)   
VALUES (3, 3, '01480/2020', 'Reforma banheiro', '2020-04-05','2020-07-31','2020-08-25');
INSERT INTO ORDEM_SERVICO (id_cliente, id_endereco, numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto)   
VALUES (4, 4, '01481/2020', 'Reforma geral', '2020-04-30','2020-08-31','2020-09-25');
INSERT INTO ORDEM_SERVICO (id_cliente, id_endereco, numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto)   
VALUES (5, 5, '01482/2020', 'Pintura Geral', '2020-05-01','2020-05-31','2020-07-31');

INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (1 , 1);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (1 , 2);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (1 , 3);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (2 , 4);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (3 , 5);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (3 , 6);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (4 , 7);
INSERT INTO ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria) VALUES (5 , 8);

INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (1 , 1);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (1 , 2);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (1 , 3);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (2 , 5);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (3 , 2);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (3 , 4);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (4 , 2);
INSERT INTO ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional) VALUES (5 , 3);









