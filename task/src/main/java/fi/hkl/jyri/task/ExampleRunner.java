package fi.hkl.jyri.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleRunner {

    public static void main(String[] args) {
        Map<Customer, Map<Product, List<Integer>>> billingMap = new HashMap<>();

        for (InvoiceItem item : items) {
            var itemProductCategory = item.getProduct().getCategory();
            var billableProduct = item.getCustomer().paysForCategory(itemProductCategory);

            // if customer should be billed for this item type, add to map
            if (Boolean.TRUE.equals(billableProduct)) {
                billingMap
                        .computeIfAbsent(item.getCustomer(), c -> new HashMap<>())
                        .computeIfAbsent(item.getProduct(), p -> new ArrayList<Integer>())
                        .add(item.getAmount());
            }
        }

        for (var entry : billingMap.entrySet()) {
            Customer customer = entry.getKey();
            String customerId = customer.getCustomerId();
            String categoryName = customer.getCategory().getName();
            System.out.printf("%-10s (%s)%n", customerId, categoryName);

            // if customer should pay a monthly fee, add it
            if (customer.paysForCategory(ProductCategory.MONTHLY_FEE)) {
                entry.getValue().put(products.get(6), List.of(1));
            }

            var customerBillables = entry.getValue().entrySet();
            double customerSum = 0d;

            for (var billable : customerBillables) {
                Product product = billable.getKey();
                Integer productCount = billable
                        .getValue()
                        .stream()
                        .reduce(0, Integer::sum);
                Double unitPrice = product.getPrice();
                String unit = product.getUnit();
                Double productTotal = productCount * unitPrice;
                String productName = product.getName();
                customerSum += productTotal;

                System.out.printf("  %-45s %4d %4s %8.2f/%-4s %8.2f%n",
                        productName, productCount, unit, unitPrice, unit, productTotal);
            }

            System.out.printf("Kokonaissumma %66.2f%n", customerSum);
            System.out.println();
        }
    }

    private static final ArrayList<Product> products = new ArrayList<>(
            List.of(
                    new Product("Lainhuutotodistus", ProductCategory.DOCUMENT, 5d, "kpl"),
                    new Product("Rasitustodistus", ProductCategory.DOCUMENT, 10d, "kpl"),
                    new Product("Vuokraoikeustodistus", ProductCategory.DOCUMENT, 5d, "kpl"),
                    new Product("Lainhuutotodistus oikeaksi todistettava", ProductCategory.CERTIFIED_DOCUMENT, 5d, "kpl"),
                    new Product("Rasitustodistus oikeaksi todistettava", ProductCategory.CERTIFIED_DOCUMENT, 10d, "kpl"),
                    new Product("Vuokraoikeustodistus oikeaksi todistettava", ProductCategory.CERTIFIED_DOCUMENT, 5d, "kpl"),
                    new Product("Ylläpitomaksu", ProductCategory.MONTHLY_FEE, 15d, "kk")
            ));

    private static final ArrayList<Customer> customers = new ArrayList<>(
            List.of(
                    new Customer("asiakas1", new CustomerCategory("kiinteistönvälittäjät")),
                    new Customer("asiakas2", new CustomerCategory("maistraatit")),
                    new Customer("asiakas3", new CustomerCategory("kunnat")),
                    new Customer("asiakas4", new CustomerCategory("kiinteistönvälittäjät"))
            ));

    private static final ArrayList<InvoiceItem> items = new ArrayList<>(
            List.of(
                    new InvoiceItem(customers.get(0), products.get(0), LocalDate.of(2023, 4, 1), 1),
                    new InvoiceItem(customers.get(0), products.get(5), LocalDate.of(2023, 4, 1), 8),
                    new InvoiceItem(customers.get(0), products.get(1), LocalDate.of(2023, 4, 4), 1),
                    new InvoiceItem(customers.get(1), products.get(4), LocalDate.of(2023, 4, 2), 2),
                    new InvoiceItem(customers.get(1), products.get(3), LocalDate.of(2023, 4, 7), 1),
                    new InvoiceItem(customers.get(1), products.get(2), LocalDate.of(2023, 4, 7), 1),
                    new InvoiceItem(customers.get(2), products.get(2), LocalDate.of(2023, 4, 2), 5),
                    new InvoiceItem(customers.get(2), products.get(5), LocalDate.of(2023, 4, 7), 7),
                    new InvoiceItem(customers.get(3), products.get(1), LocalDate.of(2023, 4, 7), 7),
                    new InvoiceItem(customers.get(3), products.get(4), LocalDate.of(2023, 4, 8), 3)
            ));

}
