
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
        Bonus bonus_1 = new Bonus(1, "DISKON1", 1000, 10000, true);
        Bonus bonus_2 = new Bonus(2,"DISKON2", 1000, 1, true);
        EwalletPayment payment_1 = new EwalletPayment(123, job_1, "1/4/2020", jobseeker_1, InvoiceStatus.Finished);
        EwalletPayment payment_2 = new EwalletPayment(234, job_1, "1/4/2020", jobseeker_1, bonus_1, InvoiceStatus.Finished);
        EwalletPayment payment_3 = new EwalletPayment(345, job_1, "1/4/2020", jobseeker_1, bonus_2, InvoiceStatus.Finished);
        payment_1.printData();
        payment_2.printData();
        payment_3.printData();
    }
}
