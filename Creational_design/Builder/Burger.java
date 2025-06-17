public class Burger {
    public enum Size{
        SMALL("Small",5.99),
        MEDIUM("Medium",6.99), 
        LARGE("Large",8.99);
        
        private final String nString;
        private final double price;
        Size(String nameString, double price) {
            this.nString=nameString;
            this.price=price;

             }
        @Override
        public String toString(){
            return nString;
        }
        public double getBasePrice(){
            return price;
        }
    }
    public enum PattyType {
        BEEF("Beef"),
        CHICKEN("Chicken"), 
        VEGGIE("Veggie");
        
        private final String nString;
        PattyType(String nameString) {
            this.nString=nameString;
             }
        @Override
        public String toString(){
            return nString;
        }

    }
    private Size size;
    private PattyType pattyType;
    private boolean cheese;
    private boolean luttuce;
    private boolean pickels;
    private double price;

    private Burger(Builder builder){
    this.size=builder.size;
    this.pattyType=builder.pattyType;
    this.cheese=builder.cheese;
    this.luttuce= builder.luttuce;
    this.pickels=builder.pickels;
    this.price=calulateprice(builder);
    }
    private double calulateprice(Builder builder){

        double total = builder.size.getBasePrice();
        if (builder.cheese) total += 1.00;
        if (builder.luttuce) total += 0.50;
        if (builder.pickels) total += 0.50;
        return total;
    }
    public void display() {
        System.out.println("\n=== YOUR BURGER ===");
        System.out.println("Size: " + size);
        System.out.println("Patty: " + pattyType);
        System.out.println("Toppings:");
        System.out.println("- Cheese: " + (cheese ? "Yes" : "No"));
        System.out.println("- Lettuce: " + (luttuce ? "Yes" : "No"));
        System.out.println("- Pickles: " + (pickels ? "Yes" : "No"));
        System.out.printf("Price: $%.2f%n", price);
    }
    public static class Builder{
        private Size size;
        private PattyType pattyType;
        private boolean cheese=false;
        private boolean luttuce=false;
        private boolean pickels=false;

        public Builder Size(Size size){
            this.size=size;
            return this;
        }
        public Builder pattyType(PattyType pattType){
            this.pattyType=pattType;
            return this;
        }
        public Builder Luttuce(boolean luttuce){
            this.luttuce=luttuce;
            return this;
        }
        public Builder Pickels(boolean pickels){
            this.pickels=pickels;
            return this;
        }
        public Builder Cheese(boolean cheese){
            this.cheese=cheese;
            return this;
        }
        

        public Burger build(){
            return new Burger(this);
        }

        
    }
public static void main(String[] args) {
    Burger Burg=new Burger.Builder().Size(Size.SMALL).pattyType(PattyType.BEEF).Cheese(true).Luttuce(true).build();
    Burg.display();
    
}

}
