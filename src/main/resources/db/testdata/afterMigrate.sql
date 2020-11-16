
set foreign_key_checks = 0;

delete from cargo;
delete from funcionario;
delete from desempenho;

set foreign_key_checks = 1;

alter table cargo auto_increment = 1;
alter table funcionario auto_increment = 1;
alter table desempenho auto_increment = 1;

insert into cargo (id, nome) values (1, 'Chefe');
insert into cargo (id, nome) values (2, 'Estagiario');
insert into cargo (id, nome) values (3, 'Desenvolvedor Junior');
insert into cargo (id, nome) values (4, 'Desenvolvedor Senior');

insert into funcionario (id, email, nome, salario, telefone, cargo_id) values (1, 'joao@gmail.com', 'João da Silva Sauro', 5000.00, '9999-9999', 2);
insert into funcionario (id, email, nome, salario, telefone, cargo_id) values (2, 'nath@gmail.com', 'Nathalia da Silva Sauro', 5000.00, '8888-8888', 1);
insert into funcionario (id, email, nome, salario, telefone, cargo_id) values (3, 'butler@gmail.com', 'Butler The Dog', 10000.00, '7777-7777', 4);
insert into funcionario (id, email, nome, salario, telefone, cargo_id) values (4, 'entei@gmail.com', 'Entei The Legendary Fire Dog', 15000.00, '6666-6666', 3);
insert into funcionario (id, email, nome, salario, telefone, cargo_id) values (5, 'raikou@gmail.com', 'Raikou The Legendary Eletric Dog', 25000.00, '5555-5555', 2);

insert into desempenho (id, data, descricao, titulo, funcionario_id) values (1, '2020-11-11', 'Legendary as always', 'Desempenho Entei Novembro', 4);
insert into desempenho (id, data, descricao, titulo, funcionario_id) values (2, '2020-11-11', 'Deu pro gasto', 'Desempenho Joao Novembro', 1);
insert into desempenho (id, data, descricao, titulo, funcionario_id) values (3, '2020-11-11', 'Funcionario excelente!', 'Desempenho Nath Novembro', 2);
insert into desempenho (id, data, descricao, titulo, funcionario_id) values (4, '2020-11-11', 'Legendary as always', 'Desempenho Raikou Novembro', 5);
insert into desempenho (id, data, descricao, titulo, funcionario_id) values (5, '2020-11-11', 'Babou demais', 'Desempenho Butler Novembro', 3);
insert into desempenho (id, data, descricao, titulo, funcionario_id) values (6, '2020-10-11', 'On fire', 'Desempenho Entei Outubro', 4);
