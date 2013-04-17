
    drop table if exists TiposBasicos;

    create table TiposBasicos (
        inte integer not null,
        long1 bigint,
        short1 smallint,
        float1 float,
        double1 double precision,
        character1 char(1),
        byte1 tinyint,
        boolean1 boolean,
        yesno1 char(1),
        truefalse1 char(1),
        stri varchar(255),
        dateDate date,
        dateTime time,
        dateTimestamp datetime,
        texto longtext,
        binario tinyblob,
        bigDecimal decimal(19,2),
        bigInteger decimal(19,2),
        primary key (inte)
    );
