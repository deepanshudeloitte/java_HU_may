import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Product {
    private String name;
    private String description;
    private double price;
    private Seller seller;

    public Product(String name, String description, double price, Seller seller) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    // Getters and setters

    // ...

    @Override
    public String toString() {
        return name + " - " + description + " - $" + price;
    }

    public double getPrice() {
        return 0;
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters

    // ...
}

class Seller extends User {
    private List<Product> products;

    public Seller(String name, String email) {
        super(name, email);
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void viewProducts() {
        System.out.println("Products for sale by " + getName() + ":");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private String getName() {
        return null;
    }
}

class Customer extends User {
    private List<Order> orders;

    public Customer(String name, String email) {
        super(name, email);
        orders = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        ShoppingCart.getInstance().addProduct(product, quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        ShoppingCart.getInstance().removeProduct(product, quantity);
    }

    public void viewCart() {
        System.out.println("Products in cart:");
        ShoppingCart.getInstance().viewCart();
    }

    public void placeOrder() {
        Order order = new Order(this, ShoppingCart.getInstance().getProducts());
        orders.add(order);
        ShoppingCart.getInstance().clearCart();
        System.out.println("Order placed: " + order);
    }

    public char[] getName() {
        return new char[0];
    }
}

class ShoppingCart {
    private static ShoppingCart instance;
    private List<Product> products;

    private ShoppingCart() {
        products = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    public void removeProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.remove(product);
        }
    }

    public void viewCart() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void clearCart() {
        products.clear();
    }
}

class Order {
    private List<Product> products;
    private Customer customer;
    private Date orderDate;

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        this.orderDate = new Date();
    }

    public double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Date: ").append(orderDate).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Products: ").append("\n");
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        sb.append("Total: $").append(getTotal());
        return sb.toString();
    }
}

public class marketPlace {
    public static void main(String[] args) {
        Seller seller = new Seller("John Doe", "john.doe@example.com");
        Customer customer = new Customer("Jane Smith", "jane.smith@example.com");

        Product product1 = new Product("Product 1", "Description 1", 9.99, seller);
        Product product2 = new Product("Product 2", "Description 2", 19.99, seller);
        Product product3 = new Product("Product 3", "Description 3", 29.99, seller);

        seller.addProduct(product1);
        seller.addProduct(product2);
        seller.addProduct(product3);

        seller.viewProducts();

        customer.addToCart(product1, 2);
        customer.addToCart(product2, 1);

        customer.viewCart();

        customer.placeOrder();
    }
}
