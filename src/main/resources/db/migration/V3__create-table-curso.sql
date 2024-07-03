create table if not exists mysqlalura.curso (
    idcurso numeric(10),
    nombre varchar(100),
    categoria varchar(100),
    status numeric(1),
    dateregister datetime,

    primary key pkCursoIdCurso (idcurso),
    unique index idxCursoNombre (nombre),
    constraint ckCursoNombreNN check ( nombre is not null),
    constraint ckCursocategoriaNN check ( categoria is not null )
    );

grant references, select on table mysqlalura.curso to root@localhost;