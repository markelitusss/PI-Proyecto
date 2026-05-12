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
        Scanner sc = new Scanner(System.in);
        int input1, input2;

        Connection con = CRUD.conectar(url, user, password);

        do {
            System.out.println("-------- ASIGNACION DE PROYECTOS --------");
            System.out.println("1. Clientes");
            System.out.println("2. Proyectos");
            System.out.println("3. Desarrolladores");
            System.out.println("4. Asignaciones de proyectos");
            System.out.println("0. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("\nElige una opción del menú: ");

            input1 = sc.nextInt();
            sc.nextLine();

            if (input1 != 3 && input1 != 0) {
                System.out.println("--------------------------");
                System.out.println("| OPCION EN CONSTRUCCION |");
                System.out.println("--------------------------\n");
            }
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
                    
                    input2 = sc.nextInt();
                    sc.nextLine();
                }
                while (input2 != 0);
            }
        }
        while (input1 != 0);

        sc.close();

        try {
            con.close();
        }
        catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
