package vincentiusindralithgow.jwork;

/**
 * Kelas RecruiterNotFoundException merupakan User-Defined Exception yang akan menjadi sebuah exception jika seorang recruiter tidak ditemukan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class RecruiterNotFoundException extends Exception{
    private int recruiter_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param recruiter_input merupakan id dari recruiter yang menyebabkan exception
     */
    public RecruiterNotFoundException(int recruiter_input){
        super("Recruiter Id: ");
        recruiter_error = recruiter_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Recruiter ID: [id] not found"
     */
    public String getMessage(){
        return super.getMessage() + recruiter_error + "Not Found";
    }
}