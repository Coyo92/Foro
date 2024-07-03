INSERT into mysqlalura.perfil (idperfil, nombre, status, dateregister)
Values (2, "USUARIO", 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (2, "ESPAÑOL", "LITERATURA" , 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (3, "INGLES", "LITERATURA" , 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (4, "FRANCES", "LITERATURA" , 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (5, "MATEMATICAS", "MATEMATICAS" , 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (6, "CIENCIAS NATURALES", "CIENCIAS" , 1, "2024-06-27");

INSERT into mysqlalura.curso (idcurso, nombre, categoria, status, dateregister)
Values (7, "HISTORIA", "HISTORIA" , 1, "2024-06-27");

INSERT into mysqlalura.userapi (iduser,
                                idemail,
                                nombre,
                                password,
                                idperfil,
                                status,
                                dateregister)
Values (3,
        "benito@gmail.com",
        "Benito Perez",
        "$2a$10$9hDmGIuKIJ/NkUlZBxidk.9MlUnsZ4cEIs/qYRoniFs2XcGc7bbZG",
        1,
        1,
        "2024-06-27");

INSERT into mysqlalura.userapi (iduser,
                                idemail,
                                nombre,
                                password,
                                idperfil,
                                status,
                                dateregister)
Values (4,
        "fernando@gmail.com",
        "Fernando Lopez",
        "$2a$10$9hDmGIuKIJ/NkUlZBxidk.9MlUnsZ4cEIs/qYRoniFs2XcGc7bbZG",
        1,
        1,
        "2024-06-27");

INSERT into mysqlalura.userapi (iduser,
                                idemail,
                                nombre,
                                password,
                                idperfil,
                                status,
                                dateregister)
Values (5,
        "admin@gmail.com",
        "Administrador Foro",
        "$2a$10$9hDmGIuKIJ/NkUlZBxidk.9MlUnsZ4cEIs/qYRoniFs2XcGc7bbZG",
        1,
        1,
        "2024-06-27");