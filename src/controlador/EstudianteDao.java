package controlador;

import static conexionBD.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import modelo.Estudiante;

public class EstudianteDao {

    private static final String SQL_SELECT = "SELECT * FROM tab_estudiantes";
    private static final String SQL_SELECT_RELATION = "SELECT * FROM tab_estudiantes E INNER JOIN tab_docentes D ON E.id_docentes = D.id_docentes WHERE D.id_docentes = ?";
    private static final String SQL_INSERT = "INSERT INTO tab_estudiantes(id_curso, nombre, apellido, cedula, direccion, telefono, edad, genero)VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tab_estudiantes SET nombre = ?, apellido = ?,cedula= ?, direccion = ?, telefono = ?,edad = ? , genero = ? WHERE id_estu = ?";
    private static final String SQL_DELETE = "DELETE FROM tab_estudiantes WHERE id_estu = ?";

    public List<Estudiante> listarEstudiantes() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante persona = null;
        List<Estudiante> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_estu");
                int idCurso = rs.getInt("id_curso");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                String cedula = rs.getString("cedula");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                String genero = rs.getString("genero");
                persona = new Estudiante(id, idCurso, nombre, apellidos, cedula, telefono, direccion, edad, genero);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return personas;
    }

    //listar Esdiantes en Jcombox con relacion docente
    public void listarEstudinatesCombo(JComboBox combo, int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_RELATION);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                combo.addItem(new Estudiante(
                        rs.getInt("id_docentes"),
                        rs.getInt("id_estu"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    public void listarComboEstidiante(JComboBox combo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            combo.addItem("SELECCIONE");
            while (rs.next()) {
                combo.addItem(new Estudiante(
                        Integer.parseInt(rs.getString("id_docentes")),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    public int registroEstudiante(Estudiante estude) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resul = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, estude.getIdCurso());
            stmt.setString(2, estude.getNombre());
            stmt.setString(3, estude.getApellido());
            stmt.setString(4, estude.getCedula());
            stmt.setString(5, estude.getDireccion());
            stmt.setString(6, estude.getTelefono());
            stmt.setInt(7, estude.getEdad());
            stmt.setString(8, estude.getSexo());
            

            resul = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

        }
        return resul;
    }

    public int actualizarEstudiante(Estudiante estud) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, estud.getNombre());
            stmt.setString(2, estud.getApellido());
            stmt.setString(3, estud.getCedula());
            stmt.setString(4, estud.getDireccion());
            stmt.setString(5, estud.getTelefono());
            stmt.setInt(6, estud.getEdad());
            stmt.setString(7, estud.getSexo());
            
            stmt.setInt(8, estud.getIdEstudiante());
            rs = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rs;
    }

    public int eliminarEstudiante(Estudiante estud) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, estud.getIdEstudiante());
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
