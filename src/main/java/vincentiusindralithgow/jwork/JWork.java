package vincentiusindralithgow.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Write a description of class JWork here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
@SpringBootApplication
public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Jakarta Pusat, DKI Jakarta");
        Location location2 = new Location("Jawa Barat", "Bogor", "Bogor, Jawa Barat");
        Location location3 = new Location("Banten", "Serang", "Serang, Banten");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Vincent", "vincentiuslithgow@gmail.com", "088219440870", location1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Indra", "indra@gmail.com", "012345678987", location2));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Lithgow", "lithgow@gmail.com", "789876543212", location3));
        try {
            DatabaseJob.addJob(new Job(1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(1), 1000, JobCategory.BackEnd));
            DatabaseJob.addJob(new Job(2, "Frontend Engineer", DatabaseRecruiter.getRecruiterById(2), 1000, JobCategory.FrontEnd));
            DatabaseJob.addJob(new Job(3, "UI/UX Engineer", DatabaseRecruiter.getRecruiterById(2), 1000, JobCategory.UI));
            DatabaseJob.addJob(new Job(4, "UI/UX Engineer", DatabaseRecruiter.getRecruiterById(3), 1000, JobCategory.UI));
        }
        catch(RecruiterNotFoundException e){
            e.printStackTrace();
        }
        SpringApplication.run(JWork.class, args);
    }

}
