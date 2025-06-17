public class Pizza {
    private final String size;
    private final boolean chicken;
    private final boolean pepperoni;
    private final boolean cheese;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.chicken = builder.chicken;
        this.pepperoni = builder.pepperoni;
        this.cheese = builder.cheese;
    }

    public void display() {
        System.out.println("Size: " + this.size);
        System.out.println("Chicken: " + this.chicken);
        System.out.println("Pepperoni: " + this.pepperoni);
        System.out.println("Cheese: " + this.cheese);
    }

    public static class Builder {
        private String size;
        private boolean chicken = false;
        private boolean pepperoni = false;
        private boolean cheese = false;

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder chicken(boolean chicken) {
            this.chicken = chicken;
            return this;
        }

        public Builder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Pizza build() {
            if (this.size == null) {
                throw new IllegalStateException("Size must be set!");
            }
            return new Pizza(this);
        }
    }

    public static void main(String[] args) {
        Pizza myPizza = new Pizza.Builder()
            .size("Medium")
            .chicken(true)
            .pepperoni(false)
            .cheese(true)
            .build();

        myPizza.display();
    }
}
