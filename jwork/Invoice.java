/**
 * Write a description of class Invoice here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
public abstract class Invoice
{
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor untuk menginisialisi semua objek dari kelas Jobseeker
     * @param id adalah id dari sebuah invoice 
     * @param idJob adalah idJob dari sebuah invoice 
     * @param date adalah tanggal dari sebuah invoice
     * @param totalFee adalah adalah total biaya jasa dari sebuah invoice
     * @param jobseeker adalah objek dari kelas Jobseeker
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus){
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
    public Job getJob()
    {
        return job;
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
     * Sebuah getter untuk mendapatkan tipe pembayaran sebuah invoice
     * @return method ini mengembalikan atribut paymentType
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
    public void setjob(Job job)
    {
        this.job = job;
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
     * @param jobseeker merupakan sebuah objek dengan kelas InvoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus status) 
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * Sebuah method untuk menampilkan sebuah invoice
     * Method menampilkan data tentang invoice
     */
    public abstract void printData();
}
