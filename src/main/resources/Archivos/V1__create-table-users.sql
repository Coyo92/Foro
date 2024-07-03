create table if not exists mysqlalura.user (
    idUser numeric(10),
    idEmail varchar(30),
    firstName varchar(30),
    lastName varchar(30),
    fullName varchar(100),
    displayName varchar(50),
    state numeric(1),
    dateRegister date,

    primary key pkIdEmail (idEmail),
    index idxIdEmail (idEmail),
    constraint ckidUserNN check ( idUser is not null ),
    constraint ckFirstNameNN check ( firstName is not null),
    constraint ckLastNameNN check ( lastName is not null),
    constraint ckdisplayNameNN check ( displayName is not null)

);