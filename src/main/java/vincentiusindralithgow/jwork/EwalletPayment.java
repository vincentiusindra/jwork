package vincentiusindralithgow.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Kelas EwalletPayment merupakan sub-class dari kelas Invoice.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class EwalletPayment extends Invoice {
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas EwalletPayment tanpa bonus(referral code)
     * @param id adalah id dari sebuah pekerjaan
     * @param jobs adalah ArrayList objek dari kelas Job
     * @param jobseeker adalah objek dari kelas Jobseeker
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    /**
     * Constructor untuk menginisialisi semua objek dari kelas BankPayment dengan bonus(referral code)
     * @param id adalah id dari sebuah pekerjaan
     * @param jobs adalah ArrayList objek dari kelas Job
     * @param jobseeker adalah objek dari kelas Jobseeker
     * @param bonus adalah bonus yang berupa referral code untuk invoice bertipe Ewallet Payment
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus) {
        super(id, jobs, jobseeker);
        this.setBonus(bonus);
    }

    /**
     * Sebuah getter untuk mendapatkan tipe pembayaran sebuah invoice
     * @return method ini mengembalikan atribut PAYMENT_TYPE
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Sebuah getter untuk mendapatkan bonus yang berupa referral code sebuah invoice
     * @return method ini mengembalikan atribut bonus
     */
    public Bonus getBonus() {
        return bonus;
    }

    /**
     * Sebuah setter untuk menentukan bonus yang berupa referral code sebuah invoice
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    /**
     * Sebuah setter untuk menentukan total biaya jasa sebuah invoice
     */
    @Override
    public void setTotalFee() {
        ArrayList<Job> jobs = getJobs();
        for(Job job: jobs){
            int fee = job.getFee();
            if (bonus != null && (bonus.getActive() == true) && fee > bonus.getMinTotalFee()) {
                super.totalFee += fee + bonus.getExtraFee();
            }
            else {
                super.totalFee += fee;
            }
        }
    }

    /**
     * Sebuah method untuk menampilkan informasi mengenai invoice terkait
     */
    @Override
    public String toString(){
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = formattedDate.format(getDate().getTime());
        String string = "";
        for (Job job : getJobs()) {
            if ((bonus != null) && (bonus.getActive() == true) && (job.getFee() > bonus.getMinTotalFee())) {
                string = string.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = " + getJobseeker().getName() + "\nReferral Code = " + bonus.getReferralCode() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
            else {
                string = string.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = " + getJobseeker().getName() + bonus.getReferralCode() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
        }
        return string;
    }
}

