package fi.hkl.jyri.task;

import java.util.Date;

public class InvoiceItem {

    private Product product;
    private Date date;
    private Integer amount;
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public InvoiceItem(Product product, Date date, Integer amount) {
        this.product = product;
        this.date = date;
        this.amount = amount;
    }
}
