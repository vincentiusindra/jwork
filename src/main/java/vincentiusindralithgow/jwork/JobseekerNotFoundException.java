package vincentiusindralithgow.jwork;

/**
 * Kelas JobseekerNotFoundException merupakan User-Defined Exception yang akan menjadi sebuah exception jika seorang jobseeker tidak ditemukan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class JobseekerNotFoundException extends Exception{
    private int jobseeker_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param jobseeker_input merupakan id dari jobseeker yang menyebabkan exception
     */
    public JobseekerNotFoundException(int jobseeker_input){
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Jobseeker ID: [id] not found"
     */
    public String getMessage(){
        return super.getMessage() + jobseeker_error + " not found";
    }
}