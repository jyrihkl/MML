package fi.hkl.jyri.task;

import java.util.Date;

public class Invoice {

    private String invoiceId;
    private Date billedOn;
    private Date dueOn;
    private Date paidOn;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getBilledOn() {
        return billedOn;
    }

    public void setBilledOn(Date billedOn) {
        this.billedOn = billedOn;
    }

    public Date getDueOn() {
        return dueOn;
    }

    public void setDueOn(Date dueOn) {
        this.dueOn = dueOn;
    }

    public Date getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
    }

    public Invoice(String invoiceId, Date billedOn, Date dueOn, Date paidOn) {
        this.invoiceId = invoiceId;
        this.billedOn = billedOn;
        this.dueOn = dueOn;
        this.paidOn = paidOn;
    }

}
