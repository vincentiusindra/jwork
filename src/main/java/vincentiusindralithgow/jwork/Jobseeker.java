package vincentiusindralithgow.jwork;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;



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
    public Calendar joinDate;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas Jobseeker
     * @param id adalah id dari seorang jobseeker 
     * @param name adalah nama dari seorang jobseeker 
     * @param email adalah email dari seorang jobseeker
     * @param password adalah adalah password dari seorang jobseeker
     * @param joinDate adalah tanggal bergabungnya seorang jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }

    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
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
     * @return method ini mengembalikan objek dengan kelas Calendar
     */
    public Calendar getJoinDate()
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
        String regexEmail = "^[a-zA-Z0-9&*_~]+([\\.{1}]?[a-z]+)+@[a-z0-9]+([\\.]{1}[a-z]+)+([\\.]{1}[a-z]+)+";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            this.email = email;
        }
        else{
            this.email = "";
        }
    }
    
    /**
     * Sebuah setter untuk menentukan password seorang jobseeker
     * @param password merupakan sebuah variabel String
     */
    public void setPassword(String password)
    {
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regexPassword);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            this.password = password;
        }
        else{
            this.password = "";
        }
    }
    
    /**
     * Sebuah setter untuk menentukan tanggal bergabungnya seorang jobseeker
     * @param joinDate merupakan sebuah objek dari kelas Calendar
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth) 
    {
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    @Override
    public String toString() 
    {
        if (this.joinDate == null) {
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = " + getPassword();
        } 
        else 
        {
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yyyy");
            String date = formattedDate.format(getJoinDate().getTime());
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = " + getPassword() + "\nJoin Date = " + date + "\n";
        }

    }

}

