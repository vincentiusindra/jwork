
/**
 * Write a description of class DatabaseRecruiter here.
 *
 * @author Vincentius Indra Lithgow
 * @version 20/03/2021
 */
public class DatabaseRecruiter
{
    private String[] listRecruiter;
    /**
     * Constructor untuk menginisialisi semua objek dari kelas DatabaseRecruiter
     */
    public DatabaseRecruiter()
    {
        listRecruiter = new String[1000];
    }

    /**
     * Constructor untuk menginisialisi semua objek dari kelas DatabaseRecruiter
     * @param listRecruiter adalah sebuah list yang berisi daftar semua perekrut 
     */
    public DatabaseRecruiter(String[] listJob)
    {
        this.listRecruiter = listRecruiter;
    }
    
    /**
     * Sebuah method untuk menambahkan data ke listRecruiter
     * Method ini masih kosong
     */
    public boolean addRecruiter(Recruiter recruiter)
    {
        return false;
    }
    
    /**
     * Sebuah method untuk mengurangi data dari listRecruiter
     * Method ini masih kosong
     */
    public boolean removeRecruiter(Recruiter recruiter)
    {
        return false;
    }
    
    /**
     * Sebuah getter untuk mendapatkan sebuah perekrut
     * getter ini masih kosong
     */
    public Job getRecruiter()
    {
        return null;
    }
    
    /**
     * Sebuah getter untuk mendapatkan list dari perekrut
     * @return listRecruiter merupakan daftar dari perekrut
     */
    public String[] getListRecruiter()
    {
        return listRecruiter;
    }
}
