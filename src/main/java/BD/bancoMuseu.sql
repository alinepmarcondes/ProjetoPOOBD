drop database if exists bancoMuseu;
create database bancoMuseu;

use bancoMuseu;

create table setor(
	id int auto_increment primary key,
    nome varchar(45)
);

#1:N
create table pintura(
	id int auto_increment primary key,
    nomeP varchar(50) not null,
    autorP varchar(50) not null,
    anoP int not null,
    tecnica varchar(50) not null,
    idSetor int,
    constraint fksetor
		foreign key (idSetor)
        references setor(id)
        on update cascade
        on delete cascade
);

#1:N
create table escultura(
	id int auto_increment primary key,
    nomeE varchar(50) not null,
    autorE varchar(50) not null,
    anoE int not null,
    material varchar(50) not null,
    id_Setor int,
    constraint fksetor1
		foreign key (id_Setor)
        references setor(id)
        on update cascade
        on delete cascade
);

#N:M
create table visitante(
	cpf int,
    primary key (cpf),
    nome varchar(45),
    idade int
);

create table setor_has_visitante(
	setor_id int not null,
    visitante_cpf int not null,
    primary key(setor_id, visitante_cpf),
    constraint fkSetor2
		foreign key(setor_id)
        references setor (id)
        on update cascade
        on delete cascade,
	constraint fkVisitante
		foreign key(visitante_cpf)
        references visitante (cpf)
        on update cascade
        on delete cascade
);

#1:1
create table audioGuia (
	id int auto_increment primary key,
    nome varchar(30)
);

insert into setor() values(default, "Setor 1"),
(default, "Setor 2");

insert into visitante() values(123456789,"Aline",19),
(456123789,"Júlia",24);

insert into audioGuia() values(default, "Audio Guia 1");

select * from pintura;
select * from escultura;





