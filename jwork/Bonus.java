
/**
 * Write a description of class DatabaseBonus here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
public class Bonus
{
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas Bonus
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active) {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }
    
    /**
     * Sebuah getter untuk mendapatkan id dari sebuah bonus
     * @return method ini mengembalikan atribut id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan referralCode dari sebuah bonus
     * @return method ini mengembalikan atribut referralCode
     */
    public String getReferralCode() {
        return referralCode;
    }
    
    /**
     * Sebuah getter untuk mendapatkan biaya extra dari sebuah bonus
     * @return method ini mengembalikan atribut extraFee
     */
    public int getExtraFee() {
        return extraFee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan total biaya minimal dari sebuah bonus
     * @return method ini mengembalikan atribut minTotalFee
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan status keaktifan dari sebuah bonus
     * @return method ini mengembalikan atribut active
     */
    public boolean getActive() {
        return active;
    }
    
    /**
     * Sebuah setter untuk menentukan id sebuah Bonus
     * @param id merupakan sebuah variabel integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sebuah setter untuk menentukan referral code sebuah bonus
     * @param id merupakan sebuah variabel string
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
    
    /**
     * Sebuah setter untuk menentukan biaya tambahan sebuah bonus
     * @param id merupakan sebuah variabel integer
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }
    
    /**
     * Sebuah setter untuk menentukan biaya minimal sebuah biaya
     * @param id merupakan sebuah variabel integer
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * Sebuah setter untuk menentukan status keaktifan sebuah bonus
     * @param active merupakan sebuah variabel boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Id = " + getId() + "\nReferral Code = " + getReferralCode() + "\nExtra Fee = " + getExtraFee() + "\nMin Total Fee= " + getMinTotalFee() + "\nActive Status =  " + getActive();
    }
}
