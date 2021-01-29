package controlador;

import static conexionBD.Conexion.*;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Curso;

public class CursoDao {

    private static final String SQL_SELECT = "SELECT * FROM tab_cursos";
    private static final String SQL_SELECT_LIST_LEVEL = "SELECT * FROM tab_cursos C where C.id_docentes = ? ";
    private static final String SQL_INSERT = "INSERT INTO tab_cursos(id_docentes, nivel)values(?,?)";

    //listar Docentes
    public void listarCombo(JComboBox combo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                combo.addItem(new Curso(
                        rs.getInt("id_docentes"),
                        rs.getInt("id_curso"),
                        rs.getString("nivel")
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

    //Listar los niveles donde da clases el docente..
    public void listarComboNiveles(JComboBox combo, int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_LIST_LEVEL);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            combo.removeAllItems();
            while (rs.next()) {
                combo.addItem(new Curso(
                        rs.getInt("id_docentes"),
                        rs.getInt("id_curso"),
                        rs.getString("nivel")
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

    //Insertar Nuevos Cursos
    public void isertarCurso(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, curso.getIdDoncente());
            stmt.setString(2, curso.getMateria());
            rs = stmt.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Curso Gardado.. ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }

    }
}
