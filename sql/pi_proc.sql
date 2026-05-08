-- ---------------------------------------------------
-- Actividad Final PI --------------------------------
-- Script Procedimientos Almacenados------------------
-- ---------------------------------------------------
-- Markel Canales Ramos 1º DAW -----------------------
-- ---------------------------------------------------

DELIMITER //
DROP PROCEDURE sp_get_desarrollador //
CREATE PROCEDURE sp_get_desarrollador(IN p_id INT)
BEGIN
    -- el procedimiento utiliza una sentencia SELECT 
    -- simple para obtener todos los datos de un desarrollador

    SELECT * FROM desarrollador WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_ins_desarrollador //
CREATE PROCEDURE sp_ins_desarrollador (
    IN p_DNI VARCHAR(10),
    IN p_nombre VARCHAR(50),
    IN p_apellido1 VARCHAR(50),
    IN p_apellido2 VARCHAR(50),
    IN p_email VARCHAR(100),
    IN p_fecha_alta DATE,
    OUT p_id INT
)
BEGIN
    -- el procedimiento utiliza SQL dinámico para introducir los valores
    -- del nuevo registro en la tabla
    -- además obtiene el ID del último registro insertado

    SET @declaracion = 'INSERT INTO desarrollador VALUES (NULL, ?, ?, ?, ?, ?, ?)';
    PREPARE prepared_stmt FROM @declaracion;

    SET @DNI = p_DNI;
    SET @nombre = p_nombre;
    SET @apellido1 = p_apellido1;
    SET @apellido2 = p_apellido2;
    SET @email = p_email;
    SET @fecha_alta = p_fecha_alta;

    EXECUTE prepared_stmt USING @DNI, @nombre, @apellido1, @apellido2, @email, @fecha_alta;
    SET p_id = LAST_INSERT_ID();

    DEALLOCATE PREPARE prepared_stmt;

END //
DELIMITER ;
