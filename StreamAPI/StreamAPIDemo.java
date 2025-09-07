package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamAPIDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.0, 50),
            new Product("Mouse", 25.0, 200),
            new Product("Keyboard", 75.0, 0),
            new Product("Monitor", 300.0, 75),
            new Product("Mouse", 25.0, 150) // Duplicate product name
        );
        List<String> expensiveProducts= products.stream()
            .filter(product->product.getQuantity()>0)
            .filter(product->product.getPrice()>50.0)
            .map(product->product.getName())
            .distinct()
            .sorted()
            .collect(Collectors.toList());

            System.out.println("Expensive and In-Stock Products (unique, sorted):");
        expensiveProducts.forEach(System.out::println);
    }
    
}
