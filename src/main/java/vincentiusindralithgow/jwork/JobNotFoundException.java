package vincentiusindralithgow.jwork;

/**
 * Kelas JobNotFoundException merupakan User-Defined Exception yang akan menjadi sebuah exception jika job tidak ditemukan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class JobNotFoundException extends Exception{
    private int job_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param job_input merupakan id dari job yang menyebabkan exception
     */
    public JobNotFoundException(int job_input){
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Job ID: [id] not found"
     */
    public String getMessage(){
        return super.getMessage() + job_error + " not found";
    }
}