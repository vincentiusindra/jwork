package vincentiusindralithgow.jwork;

/**
 * Kelas EmailAlreadyExistsException merupakan User-Defined Exception yang akan menjadi sebuah exception jika email dari jobseeker telah digunakan pada saat pendaftaran.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class EmailAlreadyExistsException extends Exception{
    private Jobseeker jobseeker_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param jobseeker_input merupakan objek dari kelas Jobseeker yang menyebabkan exception
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input){
        super("Jobseeker Email: ");
        this.jobseeker_error = jobseeker_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Jobseeker Email: [email] already exists."
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}