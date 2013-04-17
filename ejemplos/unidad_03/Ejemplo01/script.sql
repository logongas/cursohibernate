
    drop table if exists Direccion;

    drop table if exists Profesor;

    create table Direccion (
        Id integer not null,
        calle varchar(255),
        numero integer,
        poblacion varchar(255),
        provincia varchar(255),
        primary key (Id)
    );

    create table Profesor (
        Id integer not null,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        primary key (Id)
    );
