import java.util.GregorianCalendar;
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
        Recruiter recruiter_1 = new Recruiter(123, "Vincentius Indra Lithgow", "vincentiuslithgow@gmail.com", "08821944-870", location_1);
        Jobseeker jobseeker_1 = new Jobseeker(321, "Budi", "budi@ui.ac.id", "Budi123", new GregorianCalendar(2021, 3, 8));
        Job job_1 = new Job(135, "UI Designer", recruiter_1, 50000,JobCategory.FrontEnd);
        Bonus bonus_1 = new Bonus(246, "HEMAT", 5000, 50000, true);
        EwalletPayment invoice_1 = new EwalletPayment(111, job_1, jobseeker_1, bonus_1, InvoiceStatus.Finished);
        BankPayment invoice_2 = new BankPayment(222, job_1,  jobseeker_1, InvoiceStatus.Finished, 10);
        invoice_1.setTotalFee();
        invoice_2.setTotalFee();
        System.out.println(invoice_1.toString());
        System.out.println(invoice_2.toString());
    }
}
