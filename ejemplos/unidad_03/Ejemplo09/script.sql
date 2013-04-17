
    alter table ProfesorModulo 
        drop 
        foreign key FK935EBD2097F149CE;

    alter table ProfesorModulo 
        drop 
        foreign key FK935EBD20F659E166;

    drop table if exists Modulo;

    drop table if exists Profesor;

    drop table if exists ProfesorModulo;

    create table Modulo (
        IdModulo integer not null,
        nombre varchar(255),
        primary key (IdModulo)
    );

    create table Profesor (
        Id integer not null,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        primary key (Id)
    );

    create table ProfesorModulo (
        idProfesor integer not null,
        IdModulo integer not null,
        primary key (idModulo, IdProfesor)
    );

    alter table ProfesorModulo 
        add index FK935EBD2097F149CE (idProfesor), 
        add constraint FK935EBD2097F149CE 
        foreign key (idProfesor) 
        references Profesor (Id);

    alter table ProfesorModulo 
        add index FK935EBD20F659E166 (IdModulo), 
        add constraint FK935EBD20F659E166 
        foreign key (IdModulo) 
        references Modulo (IdModulo);
