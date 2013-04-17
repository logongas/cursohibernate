
    drop table if exists Profesor;

    drop table if exists Usuario;

    create table Profesor (
        Id integer not null,
        nombre varchar(255) not null,
        ape1 varchar(255) not null,
        ape2 varchar(255),
        primary key (Id)
    );

    create table Usuario (
        IdUsuario integer not null,
        login varchar(50) not null unique,
        nombre varchar(50) not null,
        ape1 varchar(50) not null,
        ape2 varchar(50),
        password varchar(50) not null,
        primary key (IdUsuario)
    );
