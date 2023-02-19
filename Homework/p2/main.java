import java.util.ArrayList;
import java.util.Scanner;

/**
 * CashRegister class is responsible for displaying UPC, product name, unit price,
 * total price, and receipt with item name, UPC, and price for each product.
 */
public class CashRegister {
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner scanner = new Scanner(System.in);
    Receipt receipt = new Receipt();

    /**
     * displayUPC method is responsible for displaying the UPC, product name, and unit price.
     */
    public void displayUPC() {
        System.out.println("Enter UPC for product: ");
        int upc = scanner.nextInt();
        boolean found = false;
        for (Product product : products) {
            if (product.UPC == upc) {
                found = true;
                System.out.println("Product name: " + product.name);
                System.out.println("Unit price: $" + product.unitPrice);
                receipt.addProduct(product);
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found with UPC: " + upc);
        }
    }

    /**
     * displayTotal method is responsible for displaying the total price.
     */
    public void displayTotal() {
        System.out.println("Total: $" + receipt.total);
    }

    /**
     * displayReceipt method is responsible for displaying the receipt with item name, UPC, and price for each product.
     */
    public void displayReceipt() {
        receipt.displayReceipt();
    }
}

/**
 * Product class is responsible for storing the product name, UPC, and unit price.
 */
class Product {
    String name;
    int UPC;
    double unitPrice;

    /**
     * Product constructor is used to initialize the product name, UPC, and unit price.
     *
     * @param name      Product name
     * @param UPC       Product UPC
     * @param unitPrice Product unit price
     */
    public Product(String name, int UPC, double unitPrice) {
        this.name = name;
        this.UPC = UPC;
        this.unitPrice = unitPrice;
    }
}

/**
 * Receipt class is responsible for displaying the item name, UPC, and price for each product,
 * and displaying the total price.
 */
class Receipt {
    ArrayList<Product> products = new ArrayList<Product>();
    double total = 0;

    /**
     * addProduct method is used to add the product to the receipt.
     *
     * @param product Product
     */
    public void addProduct(Product product) {
        products.add(product);
        total += product.unitPrice;
    }

    /**
     * displayReceipt method is used to display the receipt with item name, UPC, and price for each product.
     */
    public void displayReceipt() {
        System.out.println("Receipt:");
        for (Product product : products) {
            System.out.println("Product name: " + product.name);
            System.out.println("UPC: " + product.UPC);
            System.out.println("Price: $" + product.unitPrice);
        }
        System.out.println("Total: $" + total);
    }
}

/**
 * Main class is responsible for creating the product inventory and handling the cashier-system interaction.
 */
public class Main {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        Product snickersBar = new Product("Snickers bar", 101, 1);
        Product coke = new Product("Coke", 102, 2);
        Product chips = new Product("Chips", 103, 3);

        // Add default products to product inventory
        cashRegister.products.add(snickersBar);
        cashRegister.products.add(coke);
        cashRegister.products.add(chips);

        while (true) {
            // Display UPC, product name, and unit price
            cashRegister.displayUPC();
            System.out.println("Press 'P' to pay or 'Q' to quit: ");
            char input = cashRegister.scanner.next().charAt(0);
            if (input == 'P') {
                // Display total
                cashRegister.displayTotal();
                // Display receipt
                cashRegister.displayReceipt();
                break;
            } else if (input == 'Q') {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}