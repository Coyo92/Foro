create table if not exists mysqlalura.credentialUser (
    idUser numeric(10),
    idEmail varchar(30),
    password varchar(20),
    profile varchar(20),
    state numeric(1),
    dateRegister date,

    primary key pkCredUser (idEmail),
    index idxCredUser (idEmail),
    constraint ckPasswordNotNull check ( password is not null ),
    constraint ckprofileNotNull check ( profile is not null )
);

grant references, select on table user to root@localhost;

alter table mysqlalura.credentialUser add
    foreign key fkIdUser_User (idEmail) references mysqlalura.user(idEmail);