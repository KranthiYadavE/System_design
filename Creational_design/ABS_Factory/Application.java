package Creational_design.ABS_Factory;
interface Coffee{
    void brew();
    String getSize();
}

interface Pastry{
    void bake();
    String getType();
}

interface Payment{
    void processPayment(double amount);
    String getMethod();
}

class ItalianCoffee implements Coffee{
    public void brew(){
       // System.out.println("  ");
    }

    public String getSize(){
        return  "Brewing Authentic Italian Espresso - small and strong";
    }

}

class AmericanCoffee implements Coffee{
    public void brew(){
      //  System.out.println("  ");
    }

    public String getSize(){
        return  "Brewing large Americano mild and smooth";
    }

}

class FrenchCoffee implements Coffee{
    public void brew(){
        //System.out.println("");
    }

    public String getSize(){
        return  "Brewing creamy Café au Lait  perfect balance";
    }

}

class Italianpastry implements Pastry{
    public void bake(){
        //System.out.println("");
    }
    public String getType(){
        return "Baking traditional Cannoli with ricotta filling"; 
    }
}

class Americanpastry implements Pastry{
    public void bake(){
        //System.out.println("");
    }
    public String getType(){
        return "Baking fresh Donut with glaze"; 
    }
}

class Frenchpastry implements Pastry{
    public void bake(){
        System.out.println(""+ "\n");
    }
    public String getType(){
        return "Baking buttery Croissant - flaky layers"; 
    }
}

class Italianpayment implements Payment{
    private double amount;
    public void processPayment(double amount){
        this.amount=amount;

    }
    public String getMethod(){
        return "Processing " + this.amount + " payment with Cash - exact change preferred";
}
}

class Americanpayment implements Payment{
    private double amount;
    public void processPayment(double amount){
        this.amount=amount;

    }
    public String getMethod(){
        return "Processing " + this.amount + " payment with Credit Card - tap to pay";
}
}

class Frenchpayment implements Payment{
    private double amount;
    public void processPayment(double amount){
        this.amount=amount;

    }
    public String getMethod(){
        return "Processing " + this.amount + " payment with Contactless - quick and convenient";
}
}

interface CoffeeShopFactory {
    Coffee createCoffee();
    Pastry createPastry();  
    Payment createPayment();
}

class AmericanFactory implements CoffeeShopFactory{


    @Override
    public Coffee createCoffee() {
        // TODO Auto-generated method stub
        
         return new  AmericanCoffee();
    }

    @Override
    public Pastry createPastry() {
        // TODO Auto-generated method stub
       return new Americanpastry();
    }

    @Override
    public Payment createPayment() {
        // TODO Auto-generated method stub
        return new Americanpayment();
       }


}

class ItalianFactory implements CoffeeShopFactory{


    @Override
    public Coffee createCoffee() {
        // TODO Auto-generated method stub
        
         return new  ItalianCoffee();
    }

    @Override
    public Pastry createPastry() {
        // TODO Auto-generated method stub
       return new Italianpastry();
    }

    @Override
    public Payment createPayment() {
        // TODO Auto-generated method stub
        return new Italianpayment();
       }


}

class FrenchFactory implements CoffeeShopFactory{

    @Override
    public Coffee createCoffee() {
        // TODO Auto-generated method stub

         return new  FrenchCoffee();
    }

    @Override
    public Pastry createPastry() {
        // TODO Auto-generated method stub
       return new Frenchpastry();
    }

    @Override
    public Payment createPayment() {
        // TODO Auto-generated method stub
        return new Frenchpayment();
       }
}

class CoffeeShopFactoryProvider{

    public static CoffeeShopFactory getFactory(String country){
        switch(country.toLowerCase()){

            case "america":
                return new AmericanFactory();
            case "france":
                return new FrenchFactory();
            case "italy":
                return new ItalianFactory();
            default:
                throw new IllegalArgumentException(" unkonwn country");

        }
        
    }
}

public class Application {

    private CoffeeShopFactory coffeeProvider;
    private Coffee coffe;
    private Payment payment;
    private Pastry pastry;

    public Application(String Country){
        this.coffeeProvider=CoffeeShopFactoryProvider.getFactory(Country);
        this.coffe=coffeeProvider.createCoffee();
        this.payment=coffeeProvider.createPayment();
        this.pastry=coffeeProvider.createPastry();

        
    }
    public void create(double amount){
        System.out.println(coffe.getSize());
        System.out.println(pastry.getType());
        payment.processPayment(amount);
        System.out.println(payment.getMethod());
    }
    public static void main(String[] args) {

         Application Italian =new Application("Italy");
        System.out.println("=== Italian Coffee Shop Experience ===");
        Italian .create(5.50);

        Application America=new Application("America");
        System.out.println("=== American Coffee Shop Experience ===");
        America.create(8.75);

         Application French =new Application("France");
        System.out.println("=== French Coffee Shop Experience ===");
        French .create(6.25);

        
    }

    
    
}
