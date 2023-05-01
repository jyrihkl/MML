package fi.hkl.jyri.task;

import java.util.HashMap;

public class CustomerCategory {

    private String name;
    private HashMap<ProductCategory, Boolean> pricingModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<ProductCategory, Boolean> getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(HashMap<ProductCategory, Boolean> pricingModel) {
        this.pricingModel = pricingModel;
    }

    public CustomerCategory(String name, HashMap<ProductCategory, Boolean> pricingModel) {
        this.name = name;
        this.pricingModel = pricingModel;
    }

    public CustomerCategory(String name) {
        this.name = name;

        HashMap<ProductCategory, Boolean> model = new HashMap<>();
        model.put(ProductCategory.DOCUMENT, Boolean.FALSE);
        model.put(ProductCategory.CERTIFIED_DOCUMENT, Boolean.FALSE);
        model.put(ProductCategory.MONTHLY_FEE, Boolean.FALSE);

        switch (name) {
            case "kiinteistönvälittäjät" ->
                model.replaceAll((category, value) -> Boolean.TRUE);
            case "maistraatit" ->
                model.replace(ProductCategory.CERTIFIED_DOCUMENT, Boolean.TRUE);
            default -> { // "kunnat"
            }
        }

        this.pricingModel = model;
    }
}
