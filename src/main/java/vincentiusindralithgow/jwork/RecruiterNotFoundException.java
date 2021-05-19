package vincentiusindralithgow.jwork;

public class RecruiterNotFoundException extends Exception{
    private int recruiter_error;

    public RecruiterNotFoundException(int recruiter_input){
        super("Recruiter Id: ");
        recruiter_error = recruiter_input;
    }

    public String getMessage(){
        return super.getMessage() + recruiter_error + "Not FOund";
    }
}