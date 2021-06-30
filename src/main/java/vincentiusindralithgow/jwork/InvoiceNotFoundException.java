package vincentiusindralithgow.jwork;

/**
 * Kelas InvoiceNotFoundException merupakan User-Defined Exception yang akan menjadi sebuah exception jika invoice tidak ditemukan.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class InvoiceNotFoundException extends Exception{
    private int invoice_error;

    /**
     * Sebuah method untuk menentukan pesan dari exception pada super class
     * @param invoice_input merupakan id dari invoice yang menyebabkan exception
     */
    public InvoiceNotFoundException(int invoice_input){
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * Sebuah getter untuk mendapatkan pesan dari yang dihasilkan exception
     * @return method ini mengembalikan pesan dengan format "Invoice ID: [id] not found."
     */
    public String getMessage(){
        return super.getMessage() + invoice_error + " not found.";
    }
}