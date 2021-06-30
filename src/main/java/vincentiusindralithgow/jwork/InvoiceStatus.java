package vincentiusindralithgow.jwork;

/**
 * Kelas InvoiceStatus merupakan sebuah kelas enumerasi untuk mewakili status sebuah invoice.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
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
}
