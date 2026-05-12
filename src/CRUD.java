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

    public static String insertarBD(Connection con, Desarrollador d) {
        try {
            int id = -1;
            String sql = "CALL sp_ins_desarrollador(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, d.getDNI());
            cs.setString(2, d.getNombre());
            cs.setString(3, d.getApellido1());
            cs.setString(4, d.getApellido2());
            cs.setString(5, d.getEmail());
            cs.setString(6, d.getFechaAlta());
            cs.setInt(7, id);

            cs.execute();

            return "Desarrollador añadido correctamente con ID " + id;
        }
        catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static String actualizarBD(Connection con, Desarrollador d) {
        try {
            String sql = "CALL sp_upd_desarrollador(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, d.getId());
            cs.setString(2, d.getDNI());
            cs.setString(3, d.getNombre());
            cs.setString(4, d.getApellido1());
            cs.setString(5, d.getApellido2());
            cs.setString(6, d.getEmail());
            cs.setString(7, d.getFechaAlta());

            cs.execute();

            return "Datos actualizados correctamente para el desarrollador con ID: " + d.getId();
        }
        catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static String eliminarBD(Connection con, int id) {
        try {
            String sql = "CALL sp_del_desarrollador(?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();

            return "Desarrollador eliminado correctamente";
        }
        catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

}
