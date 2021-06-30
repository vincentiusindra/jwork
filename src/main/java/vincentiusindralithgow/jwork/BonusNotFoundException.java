package vincentiusindralithgow.jwork;

/**
 * Kelas BonusNotFoundException merupakan User-Defined Exception yang akan menjadi sebuah exception jika bonus tidak ditemukan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class BonusNotFoundException extends Exception{
    private int bonus_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param referral_input merupakan id dari bonus yang menyebabkan exception
     */
    public BonusNotFoundException(int referral_input){
        super("Bonus ID: ");
        bonus_error = referral_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Bonus ID: [id] not found."
     */
    public String getMessage(){
        return super.getMessage() + bonus_error + " not found.";
    }
}