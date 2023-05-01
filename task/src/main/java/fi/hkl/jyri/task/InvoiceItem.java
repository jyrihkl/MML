package fi.hkl.jyri.task;

import java.time.LocalDate;

public class InvoiceItem {

    private Customer customer;
    private Product product;
    private LocalDate date;
    private Integer amount;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public InvoiceItem(Customer customer, Product product, LocalDate date, Integer amount) {
        this.customer = customer;
        this.product = product;
        this.date = date;
        this.amount = amount;
    }
}
