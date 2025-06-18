package Factory;

// 1. Product Interface
interface PaymentProcessor {
    boolean processPayment(double amount);
    String getPaymentMethod();
}

// 2. Concrete Products
class PayPalProcessor implements PaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // PayPal logic
        return true;
    }
    
    public String getPaymentMethod() { return "PayPal"; }
}

class StripeProcessor implements PaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
        // Stripe logic
        return true;
    }
    
    public String getPaymentMethod() { return "Stripe"; }
}

// 3. Factory
class PaymentProcessorFactory {
    public static PaymentProcessor createProcessor(String type) {
        switch (type.toLowerCase()) {
            case "paypal":
                return new PayPalProcessor();
            case "stripe":
                return new StripeProcessor();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

public class OrderService {
    public static void main(String[] args) {
    String paymentType = args[0]; 
    double amount = Double.parseDouble(args[1]); 

        PaymentProcessor processor = PaymentProcessorFactory.createProcessor(paymentType);
        boolean success = processor.processPayment(amount);
        if (success) {
            System.out.println("Payment successful via " + processor.getPaymentMethod());
        }
    }
}
