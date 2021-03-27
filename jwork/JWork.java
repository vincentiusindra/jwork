
/**
 * Write a description of class JWork here.
 *
 * @author Vincentius Indra Lithgow
 * @version 18/3/2021
 */
public class JWork
{
    /**
     * Constructor untuk objek dengan kelas Jwork
     */
    public JWork()
    {

    }
    
    /**
     * Method main
     * Method ini inisialisasi beberapa objek baru
     */
    public static void main(String[] args)
    {
        Location location_1 = new Location("DKI Jakarta", "Jakarta Pusat", "Tanah Abang");
        Recruiter recruiter_1 = new Recruiter(123, "Vincentius Indra Lithgow", "vincentiuslithgow@gmail.com", "088219440870", location_1);
        Job job_1 = new Job(123, "Manager", recruiter_1, 150000, JobCategory.UI);
        Jobseeker jobseeker_1 = new Jobseeker(321, "Budi", "budi@gmail.com", "notapassword", "20/2/2020");
        Invoice invoice_1 = new Invoice(135, job_1.getId(), "20/2/2020", job_1.getFee(), jobseeker_1, PaymentType.BankPayment, InvoiceStatus.OnGoing);
        invoice_1.printData();
    }
}
