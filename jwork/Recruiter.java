
/**
 * Write a description of class Recruiter here.
 *
 * @author Vincentius Indra Lithgow
 * @version 18/3/2021
 */
public class Recruiter
{
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

     /**
     * Constructor untuk menginisialisi semua objek dari kelas Recruiter
     * @param id adalah id dari seorang recruiter 
     * @param name adalah nama dari seorang recruiter 
     * @param email adalah email dari seorang recruiter
     * @param phoneNumber adalah adalah nomor telepon dari seorang recruiter
     * @param location adalah objek dari kelas Location
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari seorang recruiter
     * @return method ini mengembalikan atribut id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan nama dari seorang recruiter
     * @return method ini mengembalikan atribut name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sebuah getter untuk mendapatkan email dari seorang recruiter
     * @return method ini mengembalikan atribut email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Sebuah getter untuk mendapatkan nomor telpon dari seorang recruiter
     * @return method ini mengembalikan atribut phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * Sebuah getter untuk mendapatkan lokasi dari seorang recruiter
     * @return method ini mengembalikan atribut location
     */
    public Location getLocation()
    {
        return this.location;
    }
    
    /**
     * Sebuah setter untuk menentukan id seorang recruiter
     * @param id merupakan sebuah variabel integer
     */
    public void setid(int id)
    {
        this.id = id;
    }
    
    /**
     * Sebuah setter untuk menentukan email seorang recruiter
     * @param email merupakan sebuah variabel String
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Sebuah setter untuk menentukan nama seorang recruiter
     * @param email merupakan sebuah variabel String
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sebuah setter untuk menentukan nomor telpon seorang recruiter
     * @param phoneNumber merupakan sebuah variabel String
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sebuah setter untuk menentukan lokasi seorang recruiter
     * @param location merupakan sebuah objek dengan kelas Location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * Sebuah method untuk menampilkan sebuah data
     * Method ini menampilkan nama dari seorang recruiter
     */
    public void printData()
    {
        System.out.println(getName());   
    }
}
