create table if not exists mysqlalura.userApi (
    iduser numeric(10),
    nombre varchar(100),
    idemail varchar(100),
    password varchar(300),
    idperfil numeric(10),
    status numeric(1),
    dateregister datetime,

    primary key pkUserApiIdEmail (iduser),
    unique index idxUserApiIdEmail (idemail),
    constraint ckUserApiNombreNN check ( nombre is not null ),
    constraint ckUserApiEmailNN check ( idemail is not null),
    constraint ckUserApiPassNN check ( password is not null ),
    constraint ckUserApiIdPerfilNN check ( idperfil is not null )
    );

grant references, select on table mysqlalura.userApi to root@localhost;

alter table mysqlalura.userApi add constraint
    fkIdPerfil_Perfil foreign key (idperfil) references mysqlalura.perfil(idperfil);