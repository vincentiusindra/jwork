package vincentiusindralithgow.jwork;

/**
 * Kelas OngoingInvoiceAlreadyExistsException merupakan User-Defined Exception yang akan menjadi sebuah exception jika invoice sudah berjalan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class OngoingInvoiceAlreadyExistsException extends Exception{
    private Invoice invoice_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param invoice_input merupakan invoice yang menyebabkan exception
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("OnGoing Invoice");
        this.invoice_error = invoice_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "OnGoing Invoice already exists."
     */
    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already exists.";
    }
}