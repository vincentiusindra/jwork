import java.util.ArrayList;
/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author Vincentius Indra Lithgow
 * @version 24  /04/2021
 */

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

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

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId)
    {
        ArrayList<Invoice> temp = new ArrayList<Invoice>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (jobseekerId == invoice.getJobseeker().getId()) {
                temp.add(invoice);
            }
            else {
                return null;
            }
        }
        return temp;
    }


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