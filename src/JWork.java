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
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Tanah Abang");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Budi", "budi@ui.ac.id", "088888888888", location1));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseRecruiter.getLastId()+1, "Vincentius Indra Lithgow", "vincentius.indra@ui.ac.id", "Password123", 2021, 04, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseRecruiter.getLastId()+1, "Vincentius Indra Lithgow", "vincentius.indra@ui.ac.id", "Password123", 2021, 04, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseRecruiter.getLastId()+1, "Indira Insiyah", "indira.insiyah@ui.ac.id", "123Password", 2021, 04, 22));
        System.out.println(DatabaseJobseeker.getJobseekerDatabase());
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Senior Frontend Engineer", DatabaseRecruiter.getRecruiterById(1), 54321, JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Junior Frontend Engineer", DatabaseRecruiter.getRecruiterById(1), 12345, JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Junior Backend Engineer", DatabaseRecruiter.getRecruiterById(1), 10000, JobCategory.BackEnd));
        System.out.println(DatabaseJob.getJobByCategory(JobCategory.FrontEnd));
        DatabaseBonus.addBonus(new Bonus(1, "HEMAT12", 1000, 500, false));
        DatabaseBonus.addBonus(new Bonus(1, "HEMAT24", 1000, 500, false));
    }
}
