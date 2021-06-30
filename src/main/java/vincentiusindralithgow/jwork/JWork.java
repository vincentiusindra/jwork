package vincentiusindralithgow.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Kelas JWork berisi inisialisasi Objek dengan kelas Location, Recruiter, Job, dan Bonus.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@SpringBootApplication
public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Jakarta Pusat, DKI Jakarta");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Vincent", "vincentiuslithgow@gmail.com", "088219440870", location1));
        
        try {
            DatabaseJob.addJob(new Job(1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(1), 1000, JobCategory.BackEnd));
            DatabaseJob.addJob(new Job(2, "Frontend Engineer", DatabaseRecruiter.getRecruiterById(1), 900, JobCategory.FrontEnd));
        }
        catch(RecruiterNotFoundException e){
            e.printStackTrace();
        }
        try {
            DatabaseBonus.addBonus(new Bonus(1, "HEMAT", 200, 500, true));
        } catch (ReferralCodeAlreadyExistsException e) {
            e.printStackTrace();
        }
        SpringApplication.run(JWork.class, args);
    }
}
