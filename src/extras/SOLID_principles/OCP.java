package extras.SOLID_principles;

/** The open-closed principle (OCP) states that software entities should be open for
 * extension, but closed for modification.
 * Importance:
 * Extensibility: New features can be added without modifying existing code.
 * Stability: Reduces the risk of introducing bugs when making changes.
 * Flexibility: Adapts to changing requirements more easily.
 */

/** Example:
 * We have a class called PaymentProcessor that processes payments for an online store.
 * Initially, the PaymentProcessor class only supports processing payments using credit cards. However, you
 * want to extend its functionality to also support processing payments using PayPal.
 */

// Base class for payment processing
abstract class PaymentProcessor {
    public abstract void processPayment(double amount);    // Pure virtual function
}

// Credit card payment processor
class CreditCardPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $ " + amount);
    }
}

// Extended Functionality
// To add support for PayPal payments, you create a new class
// PayPalPaymentProcessor that extends PaymentProcessor

// PayPal payment processor
class PayPalPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $ " + amount);
    }
}

public class OCP {
    // Function to process payment
    public static void processPayment(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }

    // main
    public static void main(String[] args) {
        CreditCardPaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor();

        PayPalPaymentProcessor payPalPaymentProcessor = new PayPalPaymentProcessor();

        // static function from class OCP
        processPayment(creditCardPaymentProcessor, 100.50);
        processPayment(payPalPaymentProcessor, 156.99);

    }
}