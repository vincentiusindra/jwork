package vincentiusindralithgow.jwork;

/**
 * Kelas Job digunakan untuk job yang bisa dilamar oleh seorang jobseeker.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class Job
{
    private int id;
    private String name;
    private int fee;
    private Recruiter recruiter;
    private JobCategory category;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas Job
     * @param id adalah id dari sebuah pekerjaan 
     * @param name adalah nama dari pekerjaan tersebut 
     * @param recruiter adalah objek dari kelas Recruiter
     * @param fee adalah adalah biasa jasa untuk pekerjaan tersebut
     * @param category adalah kategori dari pekerjaan tersebut
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }
    
    /**
     * Sebuah getter untuk mendapatkan id dari sebuah pekerjaan
     * @return method ini mengembalikan atribut id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan nama dari sebuah pekerjaan
     * @return method ini mengembalikan atribut nama
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sebuah getter untuk mendapatkan biaya jasa dari sebuah pekerjaan
     * @return method ini mengembalikan atribut fee
     */
    public int getFee()
    {
        return fee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan kategori dari sebuah pekerjaan
     * @return method ini mengembalikan atribut category
     */
    public JobCategory getCategory()
    {
        return category;
    }
    
    /**
     * Sebuah getter untuk mendapatkan data recruiter terkait dengan sebuah pekerjaan
     * @return method ini mengembalikan atribut-atribut dari objek recruiter 
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }

    /**
     * Sebuah setter untuk menentukan id sebuah pekerjaan
     * @param id merupakan sebuah variabel integer
     */
    public void setId(int id)
    {
       this.id = id;
    }
    
    /**
     * Sebuah setter untuk menentukan nama sebuah pekerjaan
     * @param name merupakan sebuah variabel String
     */
    public void setName(String name)
    {
       this.name = name;
    }
    
    /**
     * Sebuah setter untuk menentukan nama sebuah pekerjaan
     * @param recruiter merupakan sebuah objek dengan kelas Recruiter
     */
    public void setRecruiter(Recruiter recruiter)
    {
       this.recruiter = recruiter;
    }
    
    /**
     * Sebuah setter untuk menentukan biaya jasa sebuah pekerjaan
     * @param fee merupakan sebuah variabel integer
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }

    /**
     * Sebuah setter untuk menentukan kategori sebuah pekerjaan
     * @param category merupakan sebuah variabel String
     */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }

    /**
     * Sebuah method untuk menampilkan informasi mengenai job terkait
     */
    @Override
    public String toString() 
    {
        return "Id = " + getId() + "\nName = " + getName() + "\nRecruiter = " + getRecruiter() + "\nCity= " + getRecruiter().getLocation().getCity() + "\nFee = " + getFee() + "\nCategory = " + getCategory();
    }
}
