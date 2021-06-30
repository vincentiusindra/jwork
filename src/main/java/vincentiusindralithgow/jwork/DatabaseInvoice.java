package vincentiusindralithgow.jwork;

import java.util.ArrayList;

/**
 * Kelas DatabaseBonus digunakan untuk menyimpan semua objek invoice yang disimpan di ArrayList<Invoice>.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * Sebuah getter untuk mendapatkan ArrayList<Invoice> yang berisi semua invoice
     * @return method ini mengembalikan atribut INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    /**
     * Sebuah getter untuk mendapatkan invoice dengan id yang paling akhir
     * @return method ini mengembalikan atribut lastId yang merupakan id dari invoice yang paling akhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Sebuah getter untuk mendapatkan invoice berdasarkan id yang dimilikinya
     * @param id merupakan id dari invoice yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan invoice dengan id yang diminta
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        Invoice tempVar = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                tempVar = invoice;
            } else {
                tempVar = null;
            }
        }
        if (tempVar == null){
            throw new InvoiceNotFoundException(id);
        }
        return tempVar;
    }

    /**
     * Sebuah getter untuk mendapatkan invoice berdasarkan jobseekernya
     * @param jobseekerId merupakan id jobseeker yang diminta
     * @return method ini mengembalikan atribut tempVar yang merupakan invoice dengan jobseeker yang diminta
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId)
    {
        ArrayList<Invoice> temp = new ArrayList<Invoice>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (jobseekerId == invoice.getJobseeker().getId()) {
                temp.add(invoice);
            }
        }
        return temp;
    }

    /**
     * Sebuah method untuk menambahkan invoice kedalam database
     * @param invoice merupakan bonus yang ingin dimasukkan kedalam database invoice
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penambahan invoice ke database
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException{
        for (Invoice invoicee : INVOICE_DATABASE) {
            if (invoicee.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * Sebuah method untuk mengganti status invoice
     * @param id merupakan id dari invoice yang statusnya ingin diganti
     * @param invoiceStatus merupakan status yang diinginkan
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penggantian status invoice
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        boolean tempBool = true;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId() && invoice.getInvoiceStatus() == InvoiceStatus.OnGoing) {
                invoice.setInvoiceStatus(invoiceStatus);
                tempBool = true;
            }
            tempBool = false;
        }
        return tempBool;
    }

    /**
     * Sebuah method untuk menghapus sebuah invoice
     * @param id merupakan id dari invoice yang ingin dihapus
     * @return method ini mengembalikan sebuah boolean yang menandakan kesuksesan penghapusan invoice
     * @throws InvoiceNotFoundException jika invoice dengan id yang diberikan tidak ditemukan
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}