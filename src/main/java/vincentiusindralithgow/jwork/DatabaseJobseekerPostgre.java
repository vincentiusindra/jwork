package vincentiusindralithgow.jwork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Kelas DatabaseJobseekerPostgre digunakan untuk menyimpan semua data mengenai seorang jobseeker pada PostgreSQL.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseJobseekerPostgre {
    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * sebuah method untuk menambahkan seorang jobseeker kedalam database
     * @param jobseeker objek jobseeker yang ingin dimasukkan kedalam database
     * @return method ini mengembalikan objek dari kelas jobseeker
     */
    public static Jobseeker addJobseeker (Jobseeker jobseeker){
        c = DatabaseConnectionPostgre.connection();
        try{
            stmt = c.createStatement();
            int id = jobseeker.getId();
            String name = jobseeker.getName();
            String email = jobseeker.getEmail();
            String password = jobseeker.getPassword();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datee = sdf.format(date);
            String query =  "INSERT INTO jobseeker (id, name, email, password, date)" + "VALUES (" + id + ",'" + name + "','"+ email + "','"+ password + "','" + datee + "');";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return jobseeker;
    }

    /**
     * sebuah method untuk mendapatkan id dari jobseeker yang paling akhir
     * @return method ini mengembalikan objek dari kelas jobseeker
     */
    public static int getLastId(){
        int lastId = 0;
        c = DatabaseConnectionPostgre.connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM jobseeker;");
            while (rs.next()) {
                lastId = rs.getInt("max");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan seorang jobseeker berdasarkan id-nya
     * @param id merupakan id dari jobseeker yang diinginkan
     * @return method ini mengembalikan objek dari kelas jobseeker
     */
    public static Jobseeker getJobseekerById(int id){
        Jobseeker jobseeker = null;
        c = DatabaseConnectionPostgre.connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobseeker WHERE id = "+ id +"");
            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                String password = rs.getString("password");
                jobseeker = new Jobseeker(id, name, email, password, calendar);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return jobseeker;
    }

    /**
     * Sebuah method untuk menghapus seorang jobseeker
     * @param id merupakan id dari jobseeker yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan jobseeker
     */
    public static Boolean removeJobseeker(int id){
        c = DatabaseConnectionPostgre.connection();
        try {
            stmt = c.createStatement();
            String query = "DELETE * FROM database_jobseeker WHERE id = \"+id+\";\"";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return true;
    }

    /**
     * Sebuah method untuk proses login seorang jobseeker
     * @param inputEmail merupakan email dari seorang jobseeker
     * @param inputPassword merupakan password dari seorang jobseeker
     * @return method ini mengembalikan sebuah objek dari kelas Jobseeker yang null
     */
    public static Jobseeker getJobseekerLogin(String inputEmail, String inputPassword) {
        Jobseeker jobseeker = null;
        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobseeker WHERE email = '"+ inputEmail +"' AND password = '"+ inputPassword + "';");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                String password = rs.getString("password");
                jobseeker = new Jobseeker(id, name, email, password, calendar);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return jobseeker;
    }

    /**
     * Sebuah getter untuk mendapatkan semua isi database jobseeker
     * @return method ini mengembalikan atribut jobseekers yang berisi semua jobseeker yang ada di database
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        ArrayList<Jobseeker> jobseekers = new ArrayList<>();
        Jobseeker value = null;
        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobseeker;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                String password = rs.getString("password");
                value = new Jobseeker(id, name, email, password, calendar);
                jobseekers.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return jobseekers;
    }
}
