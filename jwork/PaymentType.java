/**
 * Write a description of class DatabaseRecruiter here.
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
    public static void main(String[] args)
    {
        PaymentType payment1 = PaymentType.BankPayment;
        PaymentType payment2 = PaymentType.EwalletPayment;
        System.out.println(payment1);
        System.out.println(payment2);
    }
}
