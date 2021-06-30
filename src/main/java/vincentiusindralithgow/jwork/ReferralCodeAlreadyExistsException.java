package vincentiusindralithgow.jwork;

/**
 * Kelas ReferralCodeAlreadyExistsException merupakan User-Defined Exception yang akan menjadi sebuah exception jika referral code ditemukan pada saat pembuatannya.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class ReferralCodeAlreadyExistsException extends Exception{
    private Bonus referral_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param referral_input merupakan referral code yang menyebabkan exception
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input){
        super("Referral Code: ");
        this.referral_error = referral_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Referral Code: [referral code] not found."
     */
    public String getMessage(){
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}