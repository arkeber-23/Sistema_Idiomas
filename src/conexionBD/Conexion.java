

package conexionBD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
  private static final String URL = "jdbc:mysql://localhost:3306/sistema_idioma";
  private static final String USER = "root";
   private static final String PASSWORD = "root23";
  
  public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, USER, PASSWORD);
  }
  
    public static void close(ResultSet rs)  {
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void close(Statement smtm ) {
        try {
            smtm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
