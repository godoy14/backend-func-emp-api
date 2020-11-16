create table cargo (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	
	primary key (id)
)engine=InnoDB default charset=utf8;

create table desempenho (
	id bigint not null auto_increment,
	data datetime not null,
	descricao varchar(150) not null,
	titulo varchar(60) not null,
	funcionario_id bigint not null,
	
	primary key (id)
)engine=InnoDB default charset=utf8;

create table funcionario (
	id bigint not null auto_increment,
	email varchar(60) not null,
	nascimento datetime not null,
	nome varchar(60) not null,
	salario decimal(10,2) not null,
	telefone varchar(15) not null,
	cargo_id bigint not null,
	
	primary key (id)
)engine=InnoDB default charset=utf8;

alter table desempenho add constraint fk_desempenho_funcionario foreign key (funcionario_id) references funcionario (id)

alter table funcionario add constraint fk_funcionario_cargo foreign key (cargo_id) references cargo (id)
