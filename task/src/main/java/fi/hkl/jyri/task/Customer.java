package fi.hkl.jyri.task;

public class Customer {

    private String customerId;
    private CustomerCategory category;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    public Customer(String customerId, CustomerCategory category) {
        this.customerId = customerId;
        this.category = category;
    }
}
