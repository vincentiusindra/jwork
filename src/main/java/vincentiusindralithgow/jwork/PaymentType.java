package vincentiusindralithgow.jwork;

/**
 * Write a description of enum class PaymentType here.
 *
 * @author Vincentius Indra Lithgow
 * @version 25/03/2021
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
