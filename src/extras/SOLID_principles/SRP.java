package extras.SOLID_principles;

/**
 * SOLID principles help enhancing loose coupling.
 * Loose coupling means group of classes are less dependent on one another.
 */


/**
 * SRP - Single Responsibility Principle - states that there should never be more than
 * one reason for a class to change. In other words, every class should have only one responsibility.
 *  Importance:
 *  Maintainability: When classes have a single, well-defined responsibility, they're easier to
 *  understand and modify.
 *  Testability: It's easier to write unit tests for classes with a single focus.
 *  Flexibility: Changes to one responsibility don't affect unrelated parts of the system.
 *  */
public class SRP {

    public void SRP() {
          System.out.println("I have only one Single Responsibility Principle.");
    }
}

class InventoryManager {
    public void manageInventory() {
        System.out.println("Managing inventory....");
    }
}

class SupplyOrder {
    public void orderSupplies() {
        System.out.println("Ordering supplies....");
    }
}

class CustomerService {
    public void serveCustomer() {
        System.out.println("Serving customers....");
    }
}


class Main {
    public static void main(String[] args) {
        SRP srp = new SRP();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        CustomerService customerService = new CustomerService();

        // Each class focuses on its specific responsibility
        srp.SRP();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        customerService.serveCustomer();
    }
}
