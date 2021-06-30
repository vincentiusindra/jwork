package vincentiusindralithgow.jwork;

/**
 * Kelas FeeCalculator mengkalkulasikan biaya total dari sebuah invoice
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public class FeeCalculator implements Runnable{
    private Invoice invoice;

    public FeeCalculator (Invoice invoice){
        this.invoice = invoice;
    }

    public void run(){
        System.out.println("Calculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finished calculating invoice id: " + invoice.getId());
    }
}