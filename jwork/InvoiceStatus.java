/**
 * Write a description of enum class InvoiceStatus here.
 *
 * @author Vincentius Indra Lithgow
 * @version 2/03/2021
 */
public enum InvoiceStatus {
    OnGoing("On Going"), Finished("Finished"), Cancelled("Cancelled");
    private String status;
    
    private InvoiceStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return status;
    }
    
    public static void main(String[] args)
    {
        
    }
}
