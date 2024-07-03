create table if not exists mysqlalura.respuesta (
    idrespuesta numeric(10),
    mensaje varchar(100),
    idtopico numeric(30),
    iduser numeric(10),
    solucion varchar(4000),
    dateregister datetime,

    primary key pkRespuestaIdRespuesta (idrespuesta),
    unique index idxRespuestaMensaje (mensaje),
    constraint ckRespuestaMensajeNN check ( mensaje is not null),
    constraint ckRespuestaSolucionNN check ( solucion is not null)
    );

grant references, select on table mysqlalura.userapi to root@localhost;
grant references, select on table mysqlalura.respuesta to root@localhost;

alter table mysqlalura.respuesta add constraint
    fkIdUser_UserApi foreign key (iduser) references mysqlalura.userApi(iduser);

alter table mysqlalura.respuesta add constraint
    fkIdTopico_Topico foreign key (idtopico) references mysqlalura.topico(idtopico);
