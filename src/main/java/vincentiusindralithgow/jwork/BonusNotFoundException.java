package vincentiusindralithgow.jwork;

public class BonusNotFoundException extends Exception{
    private int bonus_error;

    public BonusNotFoundException(int referral_input){
        super("Bonus ID: ");
        bonus_error = referral_input;
    }

    public String getMessage(){
        return super.getMessage() + bonus_error + " not found";
    }
}