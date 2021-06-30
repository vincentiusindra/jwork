package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Kelas DatabaseRecruiter digunakan untuk menyimpan semua objek Recruiter yang disimpan di ArrayList<Recruiter>.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * Sebuah getter untuk mendapatkan ArrayList<Recruiter> yang berisi semua recruiter
     * @return method ini mengembalikan atribut RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari recruiter yang paling akhir
     * @return method ini mengembalikan atribut lastId yang merupakan id dari recruiter yang paling akhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan recruiter berdasarkan id yang dimilikinya
     * @param id merupakan id dari recruiter yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan recruiter dengan id yang diminta
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException{
        Recruiter tempVar = null;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                tempVar = recruiter;
                return tempVar;
            }
        }
        throw new RecruiterNotFoundException(id);
    }

    /**
     * Sebuah method untuk menambahkan recruiter kedalam database
     * @param recruiter merupakan recruiter yang ingin dimasukkan kedalam database recruiter
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penambahan recruiter ke database
     */
    public static boolean addRecruiter(Recruiter recruiter){
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    /**
     * Sebuah method untuk menghapus seorang recruiter
     * @param id merupakan id dari recruiter yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan recruiter
     * @throws RecruiterNotFoundException jika recruiter dengan id yang diberikan tidak ditemukan
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException{
        boolean tempBool = true;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                RECRUITER_DATABASE.remove(id);
                tempBool = true;
                return tempBool;
            }
        }
        throw new RecruiterNotFoundException(id);
    }
}
