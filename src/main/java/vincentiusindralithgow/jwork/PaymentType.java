package vincentiusindralithgow.jwork;

/**
 * Kelas InvoiceStatus merupakan sebuah kelas enumerasi untuk mewakili tipe pembayaran.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public enum PaymentType {
    BankPayment("Bank Payment"), EwalletPayment("E-wallet Payment");
    private String payment;
    
    private PaymentType(String payment) {
        this.payment = payment;
    }
    
    @Override
    public String toString() {
        return payment;
    }
}
