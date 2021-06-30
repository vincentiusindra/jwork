package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Kelas DatabaseBonus digunakan untuk menyimpan semua objek Bonus yang disimpan di ArrayList<Bonus>.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseBonus {
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * Sebuah getter untuk mendapatkan ArrayList<Bonus> yang berisi semua bonus
     * @return method ini mengembalikan atribut BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
    }

    /**
     * Sebuah getter untuk mendapatkan id dari bonus yang paling akhir
     * @return method ini mengembalikan atribut lastId yang merupakan id dari bonus yang paling akhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan bonus berdasarkan id yang dimilikinya
     * @param id merupakan id dari bonus yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan bonus dengan id yang diminta
     */
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

    /**
     * Sebuah getter untuk mendapatkan bonus berdasarkan referral codenya
     * @param refferalCode merupakan referral code yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan bonus dengan referral code yang diminta
     */
    public static Bonus getBonusByRefferalCode(String refferalCode){
        Bonus tempVar = null;
        for (Bonus bonus : BONUS_DATABASE) {
            if (refferalCode.equals(bonus.getReferralCode())) {
                tempVar = bonus;
            }
        }
        return tempVar;
    }

    /**
     * Sebuah method untuk menambahkan bonus kedalam database
     * @param bonus merupakan bonus yang ingin dimasukkan kedalam database bonus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penambahan bonus ke database
     */
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

    /**
     * Sebuah method untuk mengaktifkan bonus
     * @param id merupakan id dari bonus yang ingin diaktifkan
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan pengaktifan bonus
     */
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

    /**
     * Sebuah method untuk menonaktifkan bonus
     * @param id merupakan id dari bonus yang ingin dinonaktifkan
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penonaktifan bonus
     */
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

    /**
     * Sebuah method untuk menghapus sebuah bonus
     * @param id merupakan id dari bonus yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan bonus
     * @throws BonusNotFoundException jika bonus dengan id yang diberikan tidak ditemukan
     */
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

