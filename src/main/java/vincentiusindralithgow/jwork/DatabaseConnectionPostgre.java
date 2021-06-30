package vincentiusindralithgow.jwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Kelas DatabaseConnectionPostgre digunakan untuk menyambungkan proyek dengan database PostgreSQL.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseConnectionPostgre {
    public static Connection connection(){
        Connection c = null;
        Statement stmt = null;
        String db_name = "postgres";
        String db_user = "postgres";
        String db_password = "lithgow123";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db_name, db_user, db_password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
