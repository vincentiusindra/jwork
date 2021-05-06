import java.util.ArrayList;

/**
 * Write a description of class DatabaseJobseeker here.
 *
 * @author Vincentius Indra Lithgow
 * @version 22/04/2021
 */
public class DatabaseJobseeker
{

    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException{
        Jobseeker tempVar = null;
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()) {
                tempVar = jobseeker;
                return tempVar;
            }
        }
        throw new JobseekerNotFoundException(id);
    }

    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException{
        for (Jobseeker jobseekeerr: JOBSEEKER_DATABASE) {
            if (jobseekeerr.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }

    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException{
        for (Jobseeker jobseeker: JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()) {
                JOBSEEKER_DATABASE.remove(jobseeker.getId());
                return true;
            }
        }
        throw new JobseekerNotFoundException(id);
    }
}
