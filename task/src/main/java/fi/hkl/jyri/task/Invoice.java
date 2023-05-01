package fi.hkl.jyri.task;

import java.util.Date;

public class Invoice {

    private String invoiceId;
    private Date billedOn;
    private Date dueOn;
    private Date paidOn;

    public Invoice(String invoiceId, Date billedOn, Date dueOn, Date paidOn) {
        this.invoiceId = invoiceId;
        this.billedOn = billedOn;
        this.dueOn = dueOn;
        this.paidOn = paidOn;
    }

}
