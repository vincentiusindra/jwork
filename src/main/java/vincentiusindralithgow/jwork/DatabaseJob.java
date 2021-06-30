package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Kelas DatabaseJob digunakan untuk menyimpan semua objek Job yang disimpan di ArrayList<Job>.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * Sebuah getter untuk mendapatkan ArrayList<Job> yang berisi semua job
     * @return method ini mengembalikan atribut JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari job yang paling akhir
     * @return method ini mengembalikan atribut lastId yang merupakan id dari job yang paling akhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan job berdasarkan id yang dimilikinya
     * @param id merupakan id dari job yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan job dengan id yang diminta
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        Job tempVar = null;
        for (Job jobb : JOB_DATABASE) {
            if (jobb.getId() == id) {
                tempVar = jobb;
                return tempVar;
            }
        }
        if (tempVar == null){
            throw new JobNotFoundException(id);
        }
        return tempVar;
    }

    /**
     * Sebuah getter untuk mendapatkan job berdasarkan recruiter
     * @param recruiterId merupakan id recruiter yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan job dengan recruiter yang diminta
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId){
        ArrayList<Job> tempVar = null;;
        for (Job job: JOB_DATABASE) {
            if (job.getRecruiter().getId() == recruiterId) {
                if (tempVar == null){
                    tempVar = new ArrayList<Job>();
                }
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    /**
     * Sebuah getter untuk mendapatkan job berdasarkan kategorinya
     * @param category merupakan kategori yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan job dengan kategori yang diminta
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category){
        ArrayList<Job> tempVar = null;;
        for (Job job: JOB_DATABASE) {
            if (job.getCategory() == category) {
                if (tempVar == null) {
                    tempVar = new ArrayList<Job>();
                }
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    /**
     * Sebuah method untuk menambahkan job kedalam database
     * @param job merupakan job yang ingin dimasukkan kedalam database job
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penambahan job ke database
     */
    public static boolean addJob(Job job){
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    /**
     * Sebuah method untuk menghapus sebuah job
     * @param id merupakan id dari job yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan job
     * @throws JobNotFoundException jika bonus dengan id yang diberikan tidak ditemukan
     */
    public static boolean removeJob(int id) throws JobNotFoundException{
        for (Job job: JOB_DATABASE) {
            if (job.getId() == id) {
                JOB_DATABASE.remove(job);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
}
