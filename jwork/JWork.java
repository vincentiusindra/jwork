
/**
 * Write a description of class JWork here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
public class JWork
{   
    /**
     * Method main
     * Method ini inisialisasi beberapa objek baru
     */
    public static void main(String[] args)
    {
        Location location_1 = new Location("DKI Jakarta", "Jakarta Pusat", "Tanah Abang");
        Recruiter recruiter_1 = new Recruiter(123, "Vincentius Indra Lithgow", "vincentiuslithgow@gmail.com", "088219440870", location_1);
        Job job_1 = new Job(123, "Manager", recruiter_1, 10000, JobCategory.UI);
        Jobseeker jobseeker_1 = new Jobseeker(321, "Budi", "budi@gmail.com", "notapassword", "20/2/2020");
        BankPayment test_1 = new BankPayment(024, job_1, "3/4/2020", jobseeker_1, InvoiceStatus.Finished, 0);
        BankPayment test_2 = new BankPayment(024, job_1, "3/4/2020", jobseeker_1, InvoiceStatus.Finished, 1000);
        test_1.printData();
        test_2.printData();
    }
}
