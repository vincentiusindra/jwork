package vincentiusindralithgow.jwork;

/**
 * Kelas Bonus digunakan untuk referral code yang bisa digunakan pada saat pembayaran menggunakan EwalletPayment.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
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
     * @return method ini mengembalikan id dari sebuah bonus
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sebuah getter untuk mendapatkan referralCode dari sebuah bonus
     * @return method ini mengembalikan referralCode dari sebuah bonus
     */
    public String getReferralCode() {
        return referralCode;
    }
    
    /**
     * Sebuah getter untuk mendapatkan biaya extra dari sebuah bonus
     * @return method ini mengembalikan extraFee dari sebuah bonus
     */
    public int getExtraFee() {
        return extraFee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan total biaya minimal dari sebuah bonus
     * @return method ini mengembalikan minTotalFee dari sebuah bonus
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }
    
    /**
     * Sebuah getter untuk mendapatkan status keaktifan dari sebuah bonus
     * @return method ini mengembalikan status sebuah bonus
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
     * @param referralCode merupakan sebuah variabel string
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
    
    /**
     * Sebuah setter untuk menentukan biaya tambahan sebuah bonus
     * @param extraFee merupakan sebuah variabel integer
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }
    
    /**
     * Sebuah setter untuk menentukan biaya minimal sebuah biaya
     * @param minTotalFee merupakan sebuah variabel integer
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

    /**
     * Sebuah method untuk menampilkan bonus yang berupa referral code terkait
     */
    @Override
    public String toString() {
        return "Id = " + getId() + "\nReferral Code = " + getReferralCode() + "\nExtra Fee = " + getExtraFee() + "\nMin Total Fee= " + getMinTotalFee() + "\nActive Status =  " + getActive();
    }
}
