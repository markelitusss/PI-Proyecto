-- ---------------------------------------------------
-- Actividad Final PI --------------------------------
-- Script insercion datos ----------------------------
-- ---------------------------------------------------
-- Markel Canales Ramos 1º DAW -----------------------
-- ---------------------------------------------------

USE pi_asignacion_proyectos;

-- insertamos 5 filas en la tabla desarrolladores
-- solo insertamos aquí porque es la única tabla que vamos a usar
INSERT INTO desarrollador (DNI, nombre, apellido1, apellido2, email, fecha_alta) 
VALUES 
('83412309A', 'Alfonso', 'Pérez', 'Jiménez', 'alfperjimenez@gmail.com', '2023-06-01'),
('70911233J', 'Pedro', 'Alonso', 'Martínez', 'pedroalomart@gmail.com', '2023-06-01'),
('18700257L', 'María', 'Moreno', 'López', 'mariamorlopez@gmail.com', '2024-09-15'),
('55624009Y', 'Alejandro', 'Ortega', 'Llano', 'alortegallano@gmail.com', '2025-03-01'),
('78944366P', 'Juan José', 'Vázquez', 'Recio', 'juanjovaz10@gmail.com', '2025-09-20');