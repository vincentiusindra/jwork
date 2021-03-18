
/**
 * Write a description of class Location here.
 *
 * @author Vincentius Indra Lithgow
 * @version 18/3/2021
 */
public class Location
{
    private String province;
    private String city;
    private String description;
    /**
     * Constructor untuk menginisialisi semua objek dari kelas Location
     * @param province adalah nama provinsi 
     * @param city adalah nama kota 
     * @param description adalah deskripsi lokasi
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * Sebuah getter untuk mendapatkan nama provinsi
     * @return method ini mengembalikan atribut province
     */
    public String getProvince()
    {
        return province;
    }

    /**
     * Sebuah getter untuk mendapatkan nama kota
     * @return method ini mengembalikan atribut city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sebuah getter untuk mendapatkan deskripsi lokasi
     * @return method ini mengembalikan atribut description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sebuah setter untuk menentukan provinsi
     * @param province merupakan sebuah variabel String
     */
    public void setProvince(String province)
    {
        this.province = province;
    }

    /**
     * Sebuah setter untuk menentukan kota
     * @param city merupakan sebuah variabel String
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Sebuah setter untuk menentukan deskripi lokasi
     * @param description merupakan sebuah variabel String
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Sebuah method untuk menampilkan sebuah data
     * Method ini menampilkan provinsi
     */
    public void printData()
    {
        System.out.println(getProvince());
    }
}
