package vincentiusindralithgow.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Write a description of class Invoice here.
 *
 * @author Vincentius Indra Lithgow
 * @version 1/4/2021
 */
public class BankPayment extends Invoice {
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private int adminFee;

    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker){
        super(id, jobs, jobseeker);
    }

    public BankPayment(int id, ArrayList<Job> jobs,Jobseeker jobseeker, int adminFee){
        super(id, jobs,  jobseeker);
        this.adminFee = adminFee;
    }

    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    
    public int getAdminFee() {
        return adminFee;
    }
    
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }
    
    @Override
    public void setTotalFee() {
        for(Job job : getJobs()) {
            if(adminFee != 0) {
                super.totalFee += job.getFee() - getAdminFee();
            }
            else {
                totalFee += job.getFee();
            }
        }
    }
    
    @Override
    public String toString(){
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = formattedDate.format(getDate().getTime());
        String string = "";
        for (Job job : getJobs()) {
            if (adminFee != 0) {
                string = string.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = " + getJobseeker().getName() + "\nAdmin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            } else {
                string = string.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = " + getJobseeker().getName() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
        }
        return string;
    }
}
