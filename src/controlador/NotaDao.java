package controlador;

import java.sql.Connection;

import java.util.List;
import modelo.Nota;
import static conexionBD.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaDao {

    private static final String SQL_SELECT = "select e.nombre,e.APELLIDO, n.nota from tab_notas n inner join tab_docentes d on d.ID_DOCENTES = n.ID_DOCENTES  inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU WHERE n.nota >=0";
    private static final String SQL_SELECT_EXISTS = "select count(ID_CURSO) from tab_notas where ID_ESTU = ?";
    private static final String SQL_SELECT_APPROVED = "select e.nombre,e.APELLIDO, n.nota, c.nivel from tab_notas n  inner join tab_docentes d on d.ID_DOCENTES= n.ID_DOCENTES   inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU  inner join tab_cursos c on c.ID_CURSO = n.ID_CURSO where c.nivel = ? and d.id_docentes = ? and n.NOTA >= ?";
    private static final String SQL_SELECT_NOT_APPROVED = "select e.nombre,e.APELLIDO, n.nota, c.nivel from tab_notas n  inner join tab_docentes d on d.ID_DOCENTES= n.ID_DOCENTES   inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU  inner join tab_cursos c on c.ID_CURSO = n.ID_CURSO where c.nivel = ? and d.id_docentes = ? and n.NOTA <= ?";
    private static final String SQL_SELECT_FILTER = "select n.id_nota, e.id_estu, e.nombre, e.apellido, n.nota from tab_docentes d  left join tab_cursos c  on d.id_docentes = c. id_docentes left join tab_estudiantes e on e.ID_CURSO = c.ID_CURSO left join tab_notas n on e.ID_ESTU = n.ID_ESTU where d.ID_DOCENTES = ? and c.NIVEL = ?";
    private static final String SQL_INSERT_NOTA = "INSERT INTO tab_notas(id_curso,id_estu, id_docentes, nota) VALUES (?,?,?,?) ";
    private static final String SQL_UPDATE = "UPDATE tab_notas SET id_docentes = ?, id_curso = ?, id_estu = ?, nota = ? WHERE id_nota = ?";

    public List<Nota> listarEstudiante() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota cursoNota = null;

        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("e.nombre");
                String apellido = rs.getString("e.apellido");
                double nota = rs.getDouble("n.nota");
                cursoNota = new Nota(nombre, apellido, nota);
                listaNota.add(cursoNota);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return listaNota;
    }

    //filtrar estudiantes por el docente y por  el aula
    public List<Nota> listarEstudianteAula(int idDocente, String nivel) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota _nota = null;

        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_FILTER);
            stmt.setInt(1, idDocente);
            stmt.setString(2, nivel);
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Traer los datos de las consulta
                if (!nivel.isEmpty()) {
                    int idNota = rs.getInt("n.id_nota");
                    int idEstudiante = rs.getInt("e.id_estu");
                    String nombreAlumno = rs.getString("e.nombre");
                    double nota = rs.getDouble("n.nota");
                    _nota = new Nota(nombreAlumno, idEstudiante, nota, idNota);
                    listaNota.add(_nota);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return listaNota;
    }

    public int insertarNotas(Nota nota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_NOTA);
            stmt.setInt(1, nota.getIdCurso());
            stmt.setInt(2, nota.getIdEstudinate());
            stmt.setInt(3, nota.getIdDocente());
            stmt.setDouble(4, nota.getNota());
            rs = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rs;
    }

    public int validarNotasDuplicadas(Nota nota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EXISTS);
            stmt.setInt(1, nota.getIdEstudinate());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 1;
    }

    public List<Nota> listarEstudinatesAprobados(int numero, String nivel, int idDocente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota notaAprobados = null;
        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_APPROVED);
            stmt.setString(1, nivel);
            stmt.setInt(2, idDocente);
            stmt.setInt(3, numero);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("e.nombre");
                String apellido = rs.getString("e.apellido");
                double nota = rs.getDouble("n.nota");
                notaAprobados = new Nota(nombre, apellido, nota);
                listaNota.add(notaAprobados);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return listaNota;
    }

    public List<Nota> listarEstudinatesNoAprobados(int numero, String nivel, int idDocente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota notaAprobados = null;
        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_NOT_APPROVED);
            stmt.setString(1, nivel);
            stmt.setInt(2, idDocente);
            stmt.setInt(3, numero);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("e.nombre");
                String apellido = rs.getString("e.apellido");
                double nota = rs.getDouble("n.nota");
                notaAprobados = new Nota(nombre, apellido, nota);
                listaNota.add(notaAprobados);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return listaNota;
    }

    public int actualizarNota(int idDocente, int idCurso, int idEstudiante, double nota, int idNota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, idDocente);
            stmt.setInt(2, idCurso);
            stmt.setInt(3, idEstudiante);
            stmt.setDouble(4, nota);
            stmt.setInt(5, idNota);
            rs = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
            
        }
        return rs;
    }

}
