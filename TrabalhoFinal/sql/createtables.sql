create table contribuinte(
	id int primary key,
	cpf varchar(30),
	nome varchar(100),
	idade int,
	endereco varchar(100),
	contabancaria int
);

create table dependente(
	id int primary key,
	cpf varchar(30),
	nome varchar(100),
	idade int,
	endereco varchar(100),
	idcontribuinte int references contribuinte
);

create table bem(
	id int primary key,
	nome varchar(100),
	tipo varchar(100),
	valor numeric,
	idcontribuinte int references contribuinte
);

create table pessoajuridica(
	id int primary key,
	cnpj varchar(30),
	nomepj varchar(100),
	endereco varchar(100),
	numfuncionario int
);

create table notafiscal(
	id int primary key,
	numprotocolo int,
	cnpj varchar(100),
	valor numeric,
	idpj int references pessoajuridica,
	idcontribuinte int references contribuinte
);

create table contracheque(
	id int primary key,
	numprotocolo int,
	cnpj varchar(30),
	valor numeric,
	idcontribuinte int references contribuinte,
	idpj int references pessoajuridica
);