package modelo;

public class Estudiante extends Persona {

    private int idEstudiante;
    private int idCurso;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(int idCurso, String nombre, String apellido) {
        super(nombre, apellido);
        this.idCurso = idCurso;

    }

    public Estudiante(int idCurso, int idEstudiante, String nombre, String apellido) {
        super(nombre, apellido);
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(int idCurso, String nombre, String apellido, String cedula, String telefono, String direccion, int edad, String sexo) {
        super(nombre, apellido, cedula, telefono, direccion, edad, sexo);
        this.idCurso = idCurso;

    }


    //Listar Dtos los datos
    public Estudiante(int idEstudiante, int idCurso, String nombre, String apellido, String cedula, String telefono, String direccion, int edad, String sexo) {
        super(nombre, apellido, cedula, telefono, direccion, edad, sexo);
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;

    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdEstdiante() {
        return idEstudiante;
    }

    public void setIdEstdiante(int idEstdiante) {
        this.idEstudiante = idEstdiante;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }

}
