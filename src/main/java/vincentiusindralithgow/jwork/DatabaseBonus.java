package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Write a description of class JWork here.
 *
 * @author Vincentius Indra Lithgow
 * @version 22/4/2021
 */
public class DatabaseBonus {
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus tempVar = null;
        for (Bonus bonus: BONUS_DATABASE) {
            if (id == bonus.getId()) {
                tempVar = bonus;
                return tempVar;
            }
        }
            throw new BonusNotFoundException(id);
    }

    public static Bonus getBonusByRefferalCode(String refferalCode){
        Bonus tempVar = null;
        for (Bonus bonus : BONUS_DATABASE) {
            if (refferalCode.equals(bonus.getReferralCode())) {
                tempVar = bonus;
            }
        }
        return tempVar;
    }

    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException{
        for (Bonus bonuss: BONUS_DATABASE) {
            if (bonuss.getReferralCode() == bonus.getReferralCode()) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activateBonus(int id){
        boolean tempBool = true;
        for (Bonus bonus : BONUS_DATABASE){
            if (id == bonus.getId()){
                bonus.setActive(true);
                tempBool = true;
                break;
            }
            tempBool =  false;
        }
        return tempBool;
    }

    public static boolean deactivateBonus(int id){
        boolean tempBool = true;
        for (Bonus bonus : BONUS_DATABASE){
            if (id == bonus.getId()){
                bonus.setActive(false);
                tempBool = true;
                break;
            }
            tempBool =  false;
        }
        return tempBool;
    }

    public static boolean removeBonus(int id) throws BonusNotFoundException{
        for (Bonus bonus: BONUS_DATABASE) {
            if (id == bonus.getId()) {
                BONUS_DATABASE.remove(bonus);
                return true;
            }
        }
        throw new BonusNotFoundException(id);
    }
}

