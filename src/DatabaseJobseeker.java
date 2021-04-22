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

    public static Jobseeker getJobseekerById(int id)
    {
        Jobseeker tempVar = null;
        for (Jobseeker jobseeker: JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()){
                tempVar = jobseeker;
            }
        }
        return tempVar;
    }

    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        boolean tempBool = false;
        if (JOBSEEKER_DATABASE.size() == 0){
            JOBSEEKER_DATABASE.add(jobseeker);
            lastId = jobseeker.getId();
            tempBool = true;
            return tempBool;
        }
        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (jobseeker.getEmail().equals(JOBSEEKER_DATABASE.get(i).getEmail())) {
                tempBool = false;
                return tempBool;
            } else {
                JOBSEEKER_DATABASE.add(jobseeker);
                lastId = jobseeker.getId();
                tempBool = true;
                return tempBool;
            }

        }
        return tempBool;
    }

    public static boolean removeJobseeker(int id)
    {
        boolean tempBool = true;
        for (Jobseeker jobseeker: JOBSEEKER_DATABASE) {
            if (id == jobseeker.getId()){
                JOBSEEKER_DATABASE.remove(id);
                tempBool = true;
            }
            else{
                tempBool = false;
            }
        }
        return tempBool;
    }
}
