
/**
 * Write a description of class Jobseeker here.
 *
 * @author Vincentius Indra Lithgow
 * @version 18/3/2021
 */
public class Jobseeker
{
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas Jobseeker
     * @param id adalah id dari seorang jobseeker 
     * @param name adalah nama dari seorang jobseeker 
     * @param email adalah email dari seorang jobseeker
     * @param password adalah adalah password dari seorang jobseeker
     * @param joinDate adalah tanggal bergabungnya seorang jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari seorang jobseeker
     * @return method ini mengembalikan atribut id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan nama dari seorang jobseeker
     * @return method ini mengembalikan atribut name
     */
    public String getName()
    {
        return name;   
    }
    
    /**
     * Sebuah getter untuk mendapatkan email dari seorang jobseeker
     * @return method ini mengembalikan atribut email
     */
    public String getEmail()
    {
        return email;   
    } 
    
    /**
     * Sebuah getter untuk mendapatkan password dari seorang jobseeker
     * @return method ini mengembalikan atribut password
     */
    public String getPassword()
    {
        return password;   
    }
    
    /**
     * Sebuah getter untuk mendapatkan tanggal bergabungnya dari seorang jobseeker
     * @return method ini mengembalikan atribut joinDate
     */
    public String getJoinDate()
    {
        return joinDate;   
    }
    
    /**
     * Sebuah setter untuk menentukan id seorang jobseeker
     * @param id merupakan sebuah variabel integer
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sebuah setter untuk menentukan name seorang jobseeker
     * @param name merupakan sebuah variabel String
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sebuah setter untuk menentukan email seorang jobseeker
     * @param id merupakan sebuah variabel String
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Sebuah setter untuk menentukan password seorang jobseeker
     * @param password merupakan sebuah variabel String
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * Sebuah setter untuk menentukan tanggal bergabungnya seorang jobseeker
     * @param id merupakan sebuah variabel String
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * Sebuah method untuk menampilkan sebuah data
     * Method ini menampilkan nama dari seorang jobseeker
     */
    public void printData()
    {
        System.out.println(getName());
    }
}

