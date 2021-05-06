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

    public static Job getJobById(int id) throws JobNotFoundException {
        Job tempVar = null;
        for (Job jobb : JOB_DATABASE) {
            if (id == jobb.getId()) {
                tempVar = jobb;
                return tempVar;
            }
        }
        if (tempVar == null){
            throw new JobNotFoundException(id);
        }
        return tempVar;
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId){
        ArrayList<Job> tempVar = null;;
        for (Job job: JOB_DATABASE) {
            if (job.getRecruiter().getId() == recruiterId) {
                if (tempVar == null){
                    tempVar = new ArrayList<Job>();
                }
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    public static ArrayList<Job> getJobByCategory(JobCategory category){
        ArrayList<Job> tempVar = null;;
        for (Job job: JOB_DATABASE) {
            if (job.getCategory() == category) {
                if (tempVar == null) {
                    tempVar = new ArrayList<Job>();
                }
                tempVar.add(job);
            }
        }
        return tempVar;
    }

    public static boolean addJob(Job job){
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    public static boolean removeJob(int id) throws JobNotFoundException{
        for (Job job: JOB_DATABASE) {
            if (job.getId() == id) {
                JOB_DATABASE.remove(job);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
}
