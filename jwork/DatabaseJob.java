
/**
 * Write a description of class DatabaseJob here.
 *
 * @author Vincentius Indra Lithgow
 * @version 18/3/2021
 */
public class DatabaseJob
{
    private String[] listJob;
    /**
     * Constructor untuk menginisialisi semua objek dari kelas DatabaseJob
     */
    public DatabaseJob()
    {
        listJob = new String[1000];
    }

    /**
     * Constructor untuk menginisialisi semua objek dari kelas DatabaseJob
     * @param listJob adalah sebuah list yang berisi daftar semua pekerjaan 
     */
    public DatabaseJob(String[] listJob)
    {
        this.listJob = listJob;
    }

    /**
     * Sebuah method untuk menambahkan data ke listJob
     * Method ini masih kosong
     */
    public boolean addJob(Job job)
    {
        return false;
    }

    /**
     * Sebuah method untuk mengurangi data dari listJob
     * Method ini masih kosong
     */
    public boolean removeJob(Job job)
    {
        return false;
    }

    /**
     * Sebuah getter untuk mendapatkan sebuah pekerjaan
     * getter ini masih kosong
     */
    public Job getJob()
    {
        return null;
    }
    
    /**
     * Sebuah getter untuk mendapatkan list dari pekerjaan
     * @return listJob merupakan daftar dari pekerjaan
     */
    public String[] getListJob()
    {
        return listJob;
    }
}
