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
        Jobseeker jobseeker_1 = new Jobseeker(1, "Vincent", "vincentius.indra@ui.ac.id", "pAsSwOrD123", new GregorianCalendar(2021, 4, 8));
        Jobseeker jobseeker_2 = new Jobseeker(2, "Vincent", "vincentius.indra@ui.ac.id", "Vincent2018", 2021, 04, 8);
        Jobseeker jobseeker_3 = new Jobseeker(3, "Vincent", "vincentius.indra@ui.ac.id", "Vincent2018");
        System.out.println(jobseeker_1.toString());
        System.out.println(jobseeker_2.toString());
        System.out.println(jobseeker_3.toString());
    }
}
