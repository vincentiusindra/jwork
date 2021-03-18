
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
        Location location_1 = new Location("DKI Jakarta", "Jakarta Pusat", "Menteng");
        Recruiter recruiter_1 = new Recruiter(123, "Vincentius Indra Lithgow", "vincentiuslithgow@gmail.com", "088219440870", location_1);
        Job job_1 = new Job(123, "Manager", recruiter_1, 150000, "Administration");
        Jobseeker jobseeker_1 = new Jobseeker(321, "Budi", "budi@gmail.com", "a1b2c3d4", "14/6/2021");
        Invoice invoice_1 = new Invoice(135, 123, "18 Maret 2021", 150000, jobseeker_1);
    }
}
