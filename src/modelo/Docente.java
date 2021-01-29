package modelo;

public class Docente extends Persona {

    private int idDocente;
    private String titulo;

    public Docente() {
    }

    public Docente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Docente(int idDocente, String nombre, String apellido) {
        super(nombre, apellido);
        this.idDocente = idDocente;
    }

    public Docente(String titulo, String nombre, String apellido, String cedula, String telefono, String direccion, int edad, String sexo) {
        super(nombre, apellido, cedula, telefono, direccion, edad,  sexo);
        this.titulo = titulo;
    }

    public Docente(int idDocente, String titulo, String nombre, String apellido, String cedula, String telefono, String direccion, int edad,  String sexo) {
        super(nombre, apellido, cedula, telefono, direccion, edad, sexo);
        this.idDocente = idDocente;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }


    
    
    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }

}
