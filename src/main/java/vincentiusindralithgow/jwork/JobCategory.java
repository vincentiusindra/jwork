package vincentiusindralithgow.jwork;

/**
 * Kelas InvoiceStatus merupakan sebuah kelas enumerasi untuk mewakili kategori sebuah job.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
public enum JobCategory {
    WebDeveloper("Web Developer"), FrontEnd("Front End"), BackEnd("Back End"), UI("UI"), UX("UX"), Devops("Devops"),
    DataScientist("Data Scientist"), DataAnalyst("Data Analyst");
    private String jobcategory;

    private JobCategory(String category) {
        this.jobcategory = category;
    }
    
    @Override
    public String toString() {
        return jobcategory;
    }
}