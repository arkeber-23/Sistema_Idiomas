package modelo;

public class Nota {

    private String nombre;
    private String apellido;
    private int idEstudinate;
    private int idDocente;
    private int idCurso;
    private double nota;
    private int idNota;
    private String materia;

    public Nota() {
    }

    public Nota(int idEstudinate) {
        this.idEstudinate = idEstudinate;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Nota(int idDocente, int idCurso) {
        this.idDocente = idDocente;
        this.idCurso = idCurso;
    }

    public Nota(int idEstudinate, String nombre) {
        this.nombre = nombre;
        this.idEstudinate = idEstudinate;
    }

    public Nota(String nombre, int idEstudinate, double nota) {
        this.nombre = nombre;
        this.idEstudinate = idEstudinate;
        this.nota = nota;
    }

   
    
    
    public Nota(String nombre, String apellido, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public Nota(int idEstudinate, int idDocente, int idCurso, double nota) {
        this.idEstudinate = idEstudinate;
        this.idDocente = idDocente;
        this.idCurso = idCurso;
        this.nota = nota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEstudinate() {
        return idEstudinate;
    }

    public void setIdEstudinate(int idEstudinate) {
        this.idEstudinate = idEstudinate;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" + "nombre=" + nombre + ", apellido=" + apellido + ", idEstudinate=" + idEstudinate + ", idDocente=" + idDocente + ", idCurso=" + idCurso + ", nota=" + nota + ", idNota=" + idNota + '}';
    }

}
