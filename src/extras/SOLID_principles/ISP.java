package extras.SOLID_principles;

import java.util.Arrays;
import java.util.List;

/** ISP -> Interface Segregation Principle
 * This principle applies to interfaces and is similar to the Single Responsibility Principle, focusing
 * on keeping interfaces specific and well-defined. It states that clients should not be forced to depend on methods
 * that are irrelevant to them, avoiding unnecessary dependencies. The goal is to prevent fat interfaces by using
 * multiple small, client-specific interface, each with clear and specific responsibility.
 */

/** Example:
 * Suppose if you enter a restaurant and you are pure vegetarian. The waiter
 * in that restaurant gave you the menu card which includes vegetarian items,
 * non-vegetarian items, drinks, and sweets.
 */

/**
 * Customers should receive a menu relevant to their needs (e.g., vegetarian only) instead of a
 * general menu with unnecessary items.
 * Splitting a common menu into smaller, specific ones reduces unnecessary dependencies and
 * minimizes future changes.
 */
public class ISP {
}

// Interface for vegetarian menu
interface IVegetarianMenu {
    List<String> getVegetarianItems();
}

// Interface for non-vegetarian menu
interface INonVegetarianMenu {
    List<String> getNonVegetarianItems();
}

// Interface for drinks menu
interface IDrinkMenu {
    List<String> getDrinkItems();
}


// Class for vegetarian menu
class VegetarianMenu implements IVegetarianMenu {

    @Override
    public List<String> getVegetarianItems() {
        return Arrays.asList("Salad", "Onion", "Pepper");
    }
}

// Class for non-vegetarian menu
class NonVegetarianMenu implements INonVegetarianMenu {

    @Override
    public List<String> getNonVegetarianItems() {
        return Arrays.asList("Fried Chicken", "Beef Steak with garlic", "Sheep Steak with Pepper");
    }
}

// Class for drinks menu
class DrinkMenu implements IDrinkMenu {

    @Override
    public List<String> getDrinkItems() {
        return Arrays.asList("Water", "Coke", "Cuba-Libre");
    }
}

// class Menu display
class MenuDisplay {

    // Function to display menu items for a vegetarian customer
    public static void displayVegetarianMenu(IVegetarianMenu menu) {
        System.out.println("Vegetarian Menu: ");
        for(String item: menu.getVegetarianItems()) {
            System.out.println("/ " + item);
        }
    }

    // Function to display menu items for a non-vegetarian customer
    public static void displayNonVegetarianMenu(INonVegetarianMenu menu) {
        System.out.println("Non-Vegetarian Menu: ");
        for(String item: menu.getNonVegetarianItems()) {
            System.out.println("/ " + item);
        }
    }
}

// main
class MenuApp {

    public static void main(String[] args) {

        VegetarianMenu vegetarianMenu = new VegetarianMenu();
        NonVegetarianMenu nonVegetarianMenu = new NonVegetarianMenu();
        DrinkMenu drinkMenu = new DrinkMenu();

        MenuDisplay.displayVegetarianMenu(vegetarianMenu);
        MenuDisplay.displayNonVegetarianMenu(nonVegetarianMenu);
    }

}