package vincentiusindralithgow.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vincentiusindralithgow.jwork.*;

import java.util.ArrayList;

/**
 * Kelas InvoiceController digunakan untuk menangani request yang berhubungan dengan invoice.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Sebuah method to untuk mendapatkan semua invoice pada database
     * @return method ini mengembalikan semua invoice yang ada pada database
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return (DatabaseInvoice.getInvoiceDatabase());
    }

    /**
     * Sebuah method to untuk mendapatkan invoice berdasarkan id dari invoice
     * @param id merupakan id dari invoice yang diinginkan
     * @return method ini mengembalikan invoice yang sesuai dengan id yang diinginkan
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * Sebuah method to untuk mendapatkan invoice berdasarkan id dari jobseeker
     * @param jobseekerid merupakan id dari jobseeker yang diinginkan
     * @return method ini mengembalikan invoice yang sesuai dengan id dari jobseeker yang diinginkan
     */
    @RequestMapping("/jobseeker/{jobseekerid}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerid) {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerid);
    }

    /**
     * Sebuah method to untuk mendapatkan status invoice berdasarkan id dari invoice
     * @param id merupakan id dari jobseeker yang diinginkan
     * @param status merupakan status yang invoice yang diinginkan
     * @return method ini mengembalikan sebuah objek dari kelas Invoice
     */
    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status){
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
            invoice.setInvoiceStatus(status);
            return invoice;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Sebuah method to untuk menghapus sebuah invoice berdasarkan id dari database
     * @param id merupakan id dari invoice yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean untuk menandakan kesuksesan penghapusan invoice
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sebuah method untuk menambahkan invoice dengan tipe BankPayment kedalam database
     * @param jobIdList merupakan ArrayList yang berisi id dari job yang diinginkan
     * @param jobseekerId merupakan id dari jobseeker
     * @param adminFee merupakan biaya administrasi dari invoice
     * @return method ini mengembalikan sebuah objek dari kelas Invoice
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee){
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();
        for(Integer i : jobIdList) {
            try {
                jobs.add(DatabaseJob.getJobById(i));
            } catch (JobNotFoundException e) {
                e.getMessage();
            }
        }
        invoice = new BankPayment(DatabaseInvoice.getLastId()+1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
        }
        if (status) {
            return invoice;
        } else {
            return null;
        }
    }

    /**
     * Sebuah method untuk menambahkan invoice dengan tipe EwalletPayment kedalam database
     * @param jobIdList merupakan ArrayList yang berisi id dari job yang diinginkan
     * @param jobseekerId merupakan id dari jobseeker
     * @param referralCode merupakan referral code dari sebuah bonus
     * @return method ini mengembalikan sebuah objek dari kelas Invoice
     */
    @RequestMapping(value = "createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value = "jobseekerId") int jobseekerId,
                                     @RequestParam(value = "referralCode") String referralCode) {
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i : jobIdList) {
            try {
                jobs.add(DatabaseJob.getJobById(i));
            } catch (JobNotFoundException e) {
                e.getMessage();
            }
        }
        invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), DatabaseBonus.getBonusByRefferalCode(referralCode));
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }   
        if (status) {
            return invoice;
        } else {
            return null;
        }
    }
}
