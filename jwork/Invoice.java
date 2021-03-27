/**
 * Write a description of class Invoice here.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/3/2021
 */
public class Invoice
{
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus status;
    
    /**
     * Constructor untuk menginisialisi semua objek dari kelas Jobseeker
     * @param id adalah id dari sebuah invoice 
     * @param idJob adalah idJob dari sebuah invoice 
     * @param date adalah tanggal dari sebuah invoice
     * @param totalFee adalah adalah total biaya jasa dari sebuah invoice
     * @param jobseeker adalah objek dari kelas Jobseeker
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status){
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
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
     * Sebuah getter untuk mendapatkan idJob dari sebuah invoice
     * @return method ini mengembalikan atribut idJob
     */
    public int getIdJob()
    {
        return idJob;
    }
    
    /**
     * Sebuah getter untuk mendapatkan tanggal dari sebuah invoice
     * @return method ini mengembalikan atribut date
     */
    public String getDate()
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
     * Sebuah getter untuk mendapatkan status sebuah invoice
     * @return method ini mengembalikan atribut status
     */
    public InvoiceStatus getInvoiceStatus() 
    {
        return status;
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
     * Sebuah setter untuk menentukan idJob sebuah invoice
     * @param idJob merupakan sebuah variabel integer
     */
    public void setIdJobs(int idJob)
    {
        this.idJob = idJob;
    }
    
    /**
     * Sebuah setter untuk menentukan tanggal sebuah invoice
     * @param date merupakan sebuah variabel String
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * Sebuah setter untuk menentukan total biaya jasa sebuah invoice
     * @param totalFee merupakan sebuah variabel String
     */
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
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
     * @param jobseeker merupakan sebuah objek dengan kelas InvoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus status) 
    {
        this.status = status;
    }
    
    /**
     * Sebuah method untuk menampilkan sebuah invoice
     * Method menampilkan data tentang invoice
     */
    public void printData()
    {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + id);
        System.out.println("ID Job: " + idJob);
        System.out.println("Date: " + date);
        System.out.println("Seeker: " + jobseeker.getName());
        System.out.println("Fee: " + totalFee);
        System.out.println("Status: " + status);
    }
}
