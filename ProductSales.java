/* Write a Java program that accepts a list of product sales and returns the number of products sold within specific price ranges
(e.g., $0-50, $50-100, $100-200, etc.), and the total revenue generated within each price range.*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}

public class ProductSales  {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Product A", 25.0, 10),
                new Product("Product B", 75.0, 5),
                new Product("Product C", 150.0, 8),
                new Product("Product D", 200.0, 3)
        );

        Map<String, Double> priceRanges = new HashMap<>();
        priceRanges.put("$0-50", 0.0);
        priceRanges.put("$50-100", 0.0);
        priceRanges.put("$100-200", 0.0);
        priceRanges.put("Above $200", 0.0);
        for (Product product : products) {
            double price = product.getPrice();
            int quantity = product.getQuantity();
            if (price <= 50.0) {
                priceRanges.put("$0-50", priceRanges.get("$0-50") + price * quantity);
            } else if (price <= 100.0) {
                priceRanges.put("$50-100", priceRanges.get("$50-100") + price * quantity);
            } else if (price <= 200.0) {
                priceRanges.put("$100-200", priceRanges.get("$100-200") + price * quantity);
            } else {
                priceRanges.put("Above $200", priceRanges.get("Above $200") + price * quantity);
            }
        }
        for (Map.Entry<String, Double> entry : priceRanges.entrySet()) {
            System.out.println(entry.getKey() + ": Total Revenue = $" + entry.getValue());
        }
    }
}
