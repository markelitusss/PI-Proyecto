-- ---------------------------------------------------
-- Actividad Final PI --------------------------------
-- Script creacion BBDD y Tablas ---------------------
-- ---------------------------------------------------
-- Markel Canales Ramos 1º DAW -----------------------
-- ---------------------------------------------------

-- Creación BBDD
DROP DATABASE IF EXISTS pi_asignacion_proyectos;
CREATE DATABASE pi_asignacion_proyectos;
USE pi_asignacion_proyectos;

-- Tabla cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(10),
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    email VARCHAR(100),
    telefono VARCHAR(50),
    CONSTRAINT uk_dni_cliente UNIQUE(DNI)
);

-- Tabla desarrollador
CREATE TABLE desarrollador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(10),
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    email VARCHAR(100),
    fecha_alta DATE,
    CONSTRAINT uk_dni_desarrollador UNIQUE(DNI)
);

-- Tabla proyecto
CREATE TABLE proyecto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(200),
    fecha_inicio DATE,
    fecha_fin DATE,
    horas_previstas INT
);

-- Tabla asignacion
CREATE TABLE asignacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_desarrollador INT NOT NULL,
    id_proyecto INT NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    horas_trabajadas INT,
    CONSTRAINT fk_cliente_asignacion FOREIGN KEY(id_cliente) REFERENCES cliente(id),
    CONSTRAINT fk_desarrollador_asignacion FOREIGN KEY(id_desarrollador) REFERENCES desarrollador(id),
    CONSTRAINT fk_proyecto_asignacion FOREIGN KEY(id_proyecto) REFERENCES proyecto(id)
);