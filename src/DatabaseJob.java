import java.util.ArrayList;

/**
 * Write a description of class DatabaseJob here.
 *
 * @author Vincentius Indra Lithgow
 * @version 22/4/2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Job getJobById(int id)
    {
        Job tempVar = null;
        for (Job job: JOB_DATABASE) {
            if (id == job.getId()){
                tempVar = job;
            }
        }
        return tempVar;
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        ArrayList<Job> tempVar = new ArrayList<Job>();;
        for (Job job: JOB_DATABASE) {
            if (recruiterId == job.getRecruiter().getId()){
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        ArrayList<Job> tempVar = new ArrayList<Job>();;
        for (Job job: JOB_DATABASE) {
            if (category == job.getCategory()){
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    public static boolean addJob(Job job)
    {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    public static boolean removeJob(Job job)
    {
        boolean tempBool = true;
        for (Job jobb : JOB_DATABASE) {
            if (job.getId() == job.getId()){
                JOB_DATABASE.remove(job);
                tempBool = true;
            }
            else{
                tempBool = false;
            }
        }
        return tempBool;
    }

}
