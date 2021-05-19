package vincentiusindralithgow.jwork;

import java.util.ArrayList;
/**
 * Write a description of class DatabaseRecruiter here.
 *
 * @author Vincentius Indra Lithgow
 * @version 22/04/2021
 */

public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException{
        Recruiter tempVar = null;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                tempVar = recruiter;
                return tempVar;
            }
        }
        throw new RecruiterNotFoundException(id);
    }

    public static boolean addRecruiter(Recruiter recruiter){
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException{
        boolean tempBool = true;
        for (Recruiter recruiter: RECRUITER_DATABASE) {
            if (id == recruiter.getId()) {
                RECRUITER_DATABASE.remove(id);
                tempBool = true;
                return tempBool;
            }
        }
        throw new RecruiterNotFoundException(id);
    }
}
