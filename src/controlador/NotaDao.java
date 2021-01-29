package controlador;

import java.sql.Connection;

import java.util.List;
import modelo.Nota;
import static conexionBD.Conexion.*;
import java.sql.*;
import java.util.ArrayList;

public class NotaDao {

    private static final String SQL_SELECT = "select e.nombre,e.APELLIDO, n.nota from tab_notas n inner join tab_docentes d on d.ID_DOCENTES = n.ID_DOCENTES  inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU WHERE n.nota >=0";
    private static final String SQL_SELECT_APPROVED = "select e.nombre,e.APELLIDO, n.nota from tab_notas n inner join tab_docentes d on d.ID_DOCENTES= n.ID_DOCENTES  inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU where n.NOTA >= ?";
    private static final String SQL_SELECT_NOT_APPROVED = "select e.nombre,e.APELLIDO, n.nota from tab_notas n inner join tab_docentes d on d.ID_DOCENTES= n.ID_DOCENTES  inner join tab_estudiantes e on e.ID_ESTU =  n.ID_ESTU where n.NOTA <= ?";
    private static final String SQL_SELECT_FILTER = "SELECT  e.id_estu, e.nombre FROM tab_cursos c INNER JOIN tab_estudiantes e on c.id_curso = e.id_curso  WHERE c.id_docentes = ? AND c.nivel = ?";
    private static final String SQL_INSERT_NOTA = "INSERT INTO tab_notas(id_curso,id_estu, id_docentes, nota) VALUES (?,?,?,?) ";

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
                if (!nivel.isEmpty()) {
//                    int idEstudiante = rs.getInt("e.id_estu");
//                    String nombreAlumno = rs.getString("e.nombre");
//                    double nota = rs.getDouble("n.nota");
//                    _nota = new Nota(nombreAlumno, idEstudiante, nota);
//                    listaNota.add(_nota);

                int idEstudiante = rs.getInt("e.id_estu");
                String nombreAlumno = rs.getString("e.nombre");
                _nota = new Nota(idEstudiante, nombreAlumno);
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

    public List<Nota> listarEstudinatesAprobados(int numero) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota notaAprobados = null;
        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_APPROVED);
            stmt.setInt(1, numero);
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

    public List<Nota> listarEstudinatesNoAprobados(int numero) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nota notaAprobados = null;
        List<Nota> listaNota = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_NOT_APPROVED);
            stmt.setInt(1, numero);
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

}
