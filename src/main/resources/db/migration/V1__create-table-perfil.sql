create table if not exists mysqlalura.perfil (
    idperfil numeric (10),
    nombre varchar(100),
    status numeric(1),
    dateregister datetime,

    primary key pkPerfilIdPerfil (idperfil),
    unique index idxPerfilNombre (nombre),
    constraint ckPerfilNombreNN check ( nombre is not null)
    );
grant references, select on table mysqlalura.perfil to root@localhost;