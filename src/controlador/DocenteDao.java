package controlador;

import static conexionBD.Conexion.*;
import java.sql.*;
import java.util.*;
import javax.swing.JComboBox;
import modelo.Docente;

public class DocenteDao {

    private static final String SQL_SELECT = "SELECT * FROM tab_docentes";
    private static final String SQL_INSERT = "INSERT INTO tab_docentes(nombre, apellido, cedula, direcion, telefono, edad,  titulo, genero) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tab_docentes SET nombre = ?, apellido = ?, cedula = ?, direcion = ?, telefono = ?, edad = ?,  titulo = ?, genero = ? WHERE id_docentes = ?";
    private static final String SQL_DELETE = "DELETE FROM tab_docentes WHERE id_docentes = ?";

    public List<Docente> listar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Docente persona = null;
        List<Docente> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_docentes");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                String cedula = rs.getString("cedula");
                String direccion = rs.getString("direcion");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                String genero = rs.getString("genero");
                String titulo = rs.getString("titulo");
                persona = new Docente(id, titulo, nombre, apellidos, cedula, telefono, direccion, edad, genero);
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

    public void listarCombo(JComboBox combo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                combo.addItem(new Docente(
                        rs.getInt("id_docentes"),
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

    public int registroDocente(Docente docente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, docente.getNombre());
            stmt.setString(2, docente.getApellido());
            stmt.setString(3, docente.getCedula());
            stmt.setString(4, docente.getDireccion());
            stmt.setString(5, docente.getTelefono());
            stmt.setInt(6, docente.getEdad());
            stmt.setString(7, docente.getTitulo());
            stmt.setString(8, docente.getSexo());
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public int actualizarDocente(Docente docente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, docente.getNombre());
            stmt.setString(2, docente.getApellido());
            stmt.setString(3, docente.getCedula());
            stmt.setString(4, docente.getDireccion());
            stmt.setString(5, docente.getTelefono());
            stmt.setInt(6, docente.getEdad());
            stmt.setString(7, docente.getTitulo());
            stmt.setString(8, docente.getSexo());
            stmt.setInt(9, docente.getIdDocente());
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

        return result;
    }

    public int eliminarDocente(Docente docente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, docente.getIdDocente());
            rs = stmt.executeUpdate();
            if (rs>0) {
                System.out.println("si");
            }else{
                System.out.println("no");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rs;

    }

}
