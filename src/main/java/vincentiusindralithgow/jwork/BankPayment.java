package vincentiusindralithgow.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Kelas BankPayment merupakan sub-class dari kelas Invoice.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class BankPayment extends Invoice {
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Constructor untuk menginisialisi semua objek dari kelas BankPayment tanpa biaya admin
     * @param id adalah id dari sebuah pekerjaan
     * @param jobs adalah ArrayList objek dari kelas Job
     * @param jobseeker adalah objek dari kelas Jobseeker
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker){
        super(id, jobs, jobseeker);
    }

    /**
     * Constructor untuk menginisialisi semua objek dari kelas BankPayment dengan biaya admin
     * @param id adalah id dari sebuah pekerjaan
     * @param jobs adalah ArrayList objek dari kelas Job
     * @param jobseeker adalah objek dari kelas Jobseeker
     * @param adminFee adalah biaya admin untuk invoice bertipe Bank Payment
     */
    public BankPayment(int id, ArrayList<Job> jobs,Jobseeker jobseeker, int adminFee){
        super(id, jobs,  jobseeker);
        this.adminFee = adminFee;
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
     * Sebuah getter untuk mendapatkan biaya administrasi sebuah invoice
     * @return method ini mengembalikan atribut adminFee
     */
    public int getAdminFee() {
        return adminFee;
    }

    /**
     * Sebuah setter untuk menentukan biaya administrasi sebuah invoice
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }

    /**
     * Sebuah setter untuk menentukan total biaya jasa sebuah invoice
     */
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

    /**
     * Sebuah method untuk menampilkan informasi mengenai invoice terkait
     */
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
