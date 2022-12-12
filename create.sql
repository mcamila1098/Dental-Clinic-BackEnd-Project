CREATE TABLE IF NOT EXISTS ODONTOLOGOS
(ID bigint primary key,
NOMBRE varchar(255),
APELLIDO varchar(255),
MATRICULA bigint
);

CREATE TABLE IF NOT EXISTS PACIENTES
(ID bigint primary key,
NOMBRE varchar(255),
APELLIDO varchar(255),
DOMICILIO varchar(255),
DNI bigint,
FECHADEALTA varchar(255)
);