/**
 * Write a description of class Invoice here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
public class EwalletPayment extends Invoice {
    private Bonus bonus;
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);
    }

    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);
    }

    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    @Override
    public void setTotalFee() {
        if(bonus != null && (bonus.getActive() == true) && getJob().getFee() > bonus.getMinTotalFee()){
            super.totalFee = getJob().getFee() + bonus.getExtraFee();
        } 
        else {
            super.totalFee = getJob().getFee();
        }
    }


    @Override
    public void printData() {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        if(bonus != null && (bonus.getActive() == true) && getJob().getFee() > bonus.getMinTotalFee()){
            System.out.println("ReferralCode: " + bonus.getReferralCode());
        }
        setTotalFee();
        System.out.println("Fee: " + getTotalFee());
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("Payment Type: " + PAYMENT_TYPE);
    }
}
