package modelo;

public class Curso {

    private int idDoncente;
    private int idCurso;
    private String materia;

    public Curso() {
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(int idDoncente, String materia) {
        this.idDoncente = idDoncente;
        this.materia = materia;
    }

    
    
    public Curso(int idDoncente, int idCurso, String materia) {
        this.idDoncente = idDoncente;
        this.idCurso = idCurso;
        this.materia = materia;
    }

    public int getIdDoncente() {
        return idDoncente;
    }

    public void setIdDoncente(int idDoncente) {
        this.idDoncente = idDoncente;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNota() {
        return materia;
    }

    public void setNota(String materia) {
        this.materia  = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    
    @Override
    public String toString() {
        return  materia ;
    }

    

    
    
    
}
