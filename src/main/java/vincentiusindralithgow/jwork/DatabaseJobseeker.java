package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Kelas DatabaseJobseeker digunakan untuk menyimpan semua objek jobseeker yang disimpan di ArrayList<Jobseeker>.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseJobseeker
{

    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    /**
     * Sebuah getter untuk mendapatkan ArrayList<Jobseeker> yang berisi semua jobseeker
     * @return method ini mengembalikan atribut JOBSEEKER_DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari jobseeker yang paling akhir
     * @return method ini mengembalikan atribut lastId yang merupakan id dari jobseeker yang paling akhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan seorang jobseeker berdasarkan id-nya
     * @param id merupakan id dari jobseeker yang diinginkan
     * @return method ini mengembalikan atribut id yang merupakan id dari jobseeker yang diinginkan
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException{
        Jobseeker tempVar = null;
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()) {
                tempVar = jobseeker;
                return tempVar;
            }
        }
        throw new JobseekerNotFoundException(id);
    }

    /**
     * Sebuah method untuk menambahkan jobseeker kedalam database
     * @param jobseeker merupakan jobseeker yang ingin dimasukkan kedalam database jobseeker
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penambahan jobseeker ke database
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException{
        for (Jobseeker jobseekeerr: JOBSEEKER_DATABASE) {
            if (jobseekeerr.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }

    /**
     * Sebuah method untuk menghapus seorang jobseeker
     * @param id merupakan id dari jobseeker yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan jobseeker
     * @throws JobseekerNotFoundException jika jobseeker dengan id yang diberikan tidak ditemukan
     */
    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException{
        for (Jobseeker jobseeker: JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()) {
                JOBSEEKER_DATABASE.remove(jobseeker.getId());
                return true;
            }
        }
        throw new JobseekerNotFoundException(id);
    }

    /**
     * Sebuah method untuk proses login seorang jobseeker
     * @param email merupakan email dari seorang jobseeker
     * @param password merupakan password dari seorang jobseeker
     * @return method ini mengembalikan sebuah objek dari kelas Jobseeker yang null
     */
    public static Jobseeker getJobseekerLogin(String email, String password){
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password)) {
                return jobseeker;
            }
        }
        return null;
    }
}
