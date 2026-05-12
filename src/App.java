// Actividad Final PI
// Clase principal programa
// Markel Canales Ramos 1º DAW

import java.util.Scanner;
import java.sql.*;

public class App {

    // usuario y contraseña para conectarnos a la BD
    private static final String url = System.getenv("DB_URL");
    private static final String user = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");

    public static void main(String[] args) {
        // objeto scanner y variables para recoger la selección del usuario en los menús
        Scanner sc = new Scanner(System.in);
        int input1, input2;

        // conexion a la BD
        Connection con = CRUD.conectar(url, user, password);

        // primer menú
        do {
            System.out.println("-------- ASIGNACION DE PROYECTOS --------");
            System.out.println("1. Clientes");
            System.out.println("2. Proyectos");
            System.out.println("3. Desarrolladores");
            System.out.println("4. Asignaciones de proyectos");
            System.out.println("0. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("\nElige una opción del menú: ");

            // recogemos entrada
            input1 = sc.nextInt();
            sc.nextLine();

            // si el usuario selecciona cualquier otra tabla que no sea desarrollador
            if (input1 != 3 && input1 != 0) {
                System.out.println("--------------------------");
                System.out.println("| OPCION EN CONSTRUCCION |");
                System.out.println("--------------------------\n");
            }
            // si selecciona la tabla desarrollador entra en el segundo menú
            else if (input1 == 3) {
                do {
                    System.out.println("\n-------- MANTENIMIENTO TABLA DESARROLLADOR --------");
                    System.out.println("1. Crear");
                    System.out.println("2. Consultar");
                    System.out.println("3. Modificar");
                    System.out.println("4. Eliminar");
                    System.out.println("0. Salir mantenimiento DESARROLLADOR");
                    System.out.println("---------------------------------------------------");
                    System.out.print("\n Elige una opción del menú: ");
                    
                    // recogemos entrada
                    input2 = sc.nextInt();
                    sc.nextLine();

                    switch (input2) {
                        // inserción: pedimos todos los datos y ejecutamos la función
                        case 1 -> {
                            System.out.print("Introduzca el DNI del desarrollador: ");
                            String DNI = sc.next();
                            System.out.print("Introduzca el nombre del desarrollador: ");
                            String nombre = sc.next();
                            System.out.print("Introduzca el primer apellido del desarrollador: ");
                            String apellido1 = sc.next();
                            System.out.print("Introduzca el segundo apellido del desarrollador: ");
                            String apellido2 = sc.next();
                            System.out.print("Introduzca el email del desarrollador: ");
                            String email = sc.next();
                            System.out.print("Introduzca la fecha de alta del desarrollador (YYYY-MM-DD): ");
                            String fecha_alta = sc.next();

                            Desarrollador d = new Desarrollador(0, DNI, nombre, apellido1, apellido2, email, fecha_alta);
                            System.out.println(CRUD.insertarBD(con, d));
                        }

                        // consulta: pedimos el ID y ejecuta la función
                        case 2 -> {
                            System.out.print("Introduzca el ID del desarrollador: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.println(CRUD.consultarBD(con, id));
                        }

                        // actualización: pedimos todos los datos empezando por el ID y ejecutamos la función
                        case 3 -> {
                            System.out.print("Introduzca el ID del desarrollador: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Introduzca el DNI del desarrollador: ");
                            String DNI = sc.next();
                            System.out.print("Introduzca el nombre del desarrollador: ");
                            String nombre = sc.next();
                            System.out.print("Introduzca el primer apellido del desarrollador: ");
                            String apellido1 = sc.next();
                            System.out.print("Introduzca el segundo apellido del desarrollador: ");
                            String apellido2 = sc.next();
                            System.out.print("Introduzca el email del desarrollador: ");
                            String email = sc.next();
                            System.out.print("Introduzca la fecha de alta del desarrollador (YYYY-MM-DD): ");
                            String fecha_alta = sc.next();

                            Desarrollador d = new Desarrollador(id, DNI, nombre, apellido1, apellido2, email, fecha_alta);
                            System.out.println(CRUD.actualizarBD(con, d));
                        }

                        // borrado: pedimos el ID y ejecutamos la función
                        case 4 -> {
                            System.out.print("Introduzca el ID del desarrollador: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.println(CRUD.eliminarBD(con, id));
                        }
                    }
                }
                while (input2 != 0);
            }
        }
        while (input1 != 0);

        // cerramos scanner
        sc.close();

        // cerramos conexión
        try {
            con.close();
        }
        catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
