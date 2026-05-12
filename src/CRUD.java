// Actividad Final PI
// Clase conexion BD y funciones CRUD
// Markel Canales Ramos 1º DAW

import java.sql.*;

public class CRUD {
    
    public static Connection conectar(String url, String user, String password) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error: no se encontró el driver JDBC");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }

    public static String consultarBD(Connection con, int id) {
        try {
            String sql = "CALL sp_get_desarrollador(?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();

            Desarrollador result = 
            new Desarrollador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            return result.toString();
        }
        catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

}
