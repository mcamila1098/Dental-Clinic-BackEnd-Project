CREATE TABLE IF NOT EXISTS ODONTOLOGOS
(ID bigint primary key,
NOMBRE varchar(255),
APELLIDO varchar(255),
MATRICULA bigint
);

CREATE TABLE IF NOT EXISTS PACIENTES
(ID int auto_increment primary key,
NOMBRE varchar(255),
APELLIDO varchar(255),
DOMICILIO varchar(255),
DNI varchar(255),
FECHADEALTA varchar(255)
);