package fi.hkl.jyri.task;

public class Product {

    private String name;
    private ProductCategory category;
    private Number price;
    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Product(String name, ProductCategory category, Number price, String unit) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.unit = unit;
    }
}
