// Actividad Final PI
// Clase desarrollador
// Markel Canales Ramos 1º DAW

public class Desarrollador {
    
    // atributos (los mismos que los campos de la tabla desarrollador en la BD)
    private int id;
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String fecha_alta;

    // constructor
    public Desarrollador(int id, String DNI, String nombre, String apellido1, String apellido2, String email, String fecha_alta) {
        this.id = id;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fecha_alta = fecha_alta;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaAlta() {
        return fecha_alta;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaAlta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    // metodo toString
    @Override
    public String toString() {
        return "ID: " + id + " | DNI: " + DNI + " | Nombre: " + nombre + 
        " | Primer apellido: " + apellido1 + " | Segundo apellido: " + apellido2 + 
        " | Email: " + email + " | Fecha alta: " + fecha_alta;
    }

}
