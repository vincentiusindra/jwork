package vincentiusindralithgow.jwork;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Kelas BankPayment merupakan sebuah kelas abstract yang akan menjadi super-class dari kelas BankPayment dan EwalletPayment.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public abstract class Invoice
{
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor untuk menginisialisi semua objek dari kelas Invoice
     * @param id adalah id dari sebuah invoice 
     * @param jobs adalah ArrayList objek dari kelas Job
     * @param jobseeker adalah objek dari kelas Jobseeker
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker){
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
    }

    /**
     * Sebuah getter untuk mendapatkan id dari sebuah invoice
     * @return method ini mengembalikan atribut id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan ArrayList objek dari kelas Job
     * @return method ini mengembalikan atribut jobs
     */
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    /**
     * Sebuah getter untuk mendapatkan tanggal dari sebuah invoice
     * @return method ini mengembalikan atribut date
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Sebuah getter untuk mendapatkan total biaya jasa dari sebuah invoice
     * @return method ini mengembalikan atribut totalFee
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan jobseeker yang terkait dengan sebuah invoice
     * @return method ini mengembalikan atribut jobseeker
     */
    public Jobseeker getJobseeker() 
    {
        return jobseeker;
    }

    /**
     * Sebuah method abstract yang akan di override di sub-class
     */
    public abstract PaymentType getPaymentType();

    /**
     * Sebuah getter untuk mendapatkan status sebuah invoice
     * @return method ini mengembalikan atribut invoiceStatus
     */
    public InvoiceStatus getInvoiceStatus(){
        return invoiceStatus;
    }
    
    /**
     * Sebuah setter untuk menentukan id sebuah invoice
     * @param id merupakan sebuah variabel integer
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sebuah setter untuk menentukan Job sebuah invoice
     * @param job merupakan sebuah objek dengan kelas Job
     */
    public void setJobs(Job job)
    {
        this.jobs = jobs;
    }
    
    /**
     * Sebuah setter untuk menentukan tanggal sebuah invoice
     * @param date merupakan sebuah variabel String
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    /**
     * Sebuah setter untuk menentukan tanggal sebuah invoice
     * @param year merupakan sebuah variabel integer
     * @param month merupakan sebuah variabel integer
     * @param dayOfMonth merupakan sebuah variabel integer
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Sebuah method abstract yang akan di override di sub-class
     */
    public abstract void setTotalFee();
    
    /**
     * Sebuah setter untuk menentukan jobseeker yang terkait dengan sebuah invoice
     * @param jobseeker merupakan sebuah objek dengan kelas Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) 
    {
        this.jobseeker = jobseeker;
    }

    /**
     * Sebuah setter untuk menentukan status sebuah invoice
     * @param invoiceStatus merupakan sebuah objek dengan kelas InvoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Sebuah method abstract yang akan di override di sub-class
     */
    public abstract String toString();
}
