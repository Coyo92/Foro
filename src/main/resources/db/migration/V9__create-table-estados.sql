create table if not exists mysqlalura.estado (
    idstado numeric(10),
    estado varchar(50),
    dateregister datetime,

    primary key pkEstadoIdEstado (idstado),
    unique index idxEstadoEstado (estado),
    constraint ckEstadoEstadoNN check ( estado is not null)
    );

grant references, select on table mysqlalura.estado to root@localhost;