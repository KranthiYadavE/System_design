package Structural_Design.Decorator_Pattern;
interface Pizza{
    public String getdescription();
    public int getamount();
}

class Basic implements Pizza{
    @Override
    public String getdescription() {
        return "Basic Pizza";
        
    }

    @Override
    public int getamount() {
        return 5;
    }

}

class PizzaDecorator implements Pizza{
    public Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public String getdescription() {
        
        return pizza.getdescription();
    }
    @Override
    public int getamount() {
     
        return pizza.getamount();
    }
}

class Olives extends PizzaDecorator{

    public Olives(Pizza pizza){
        super(pizza);
    }

     @Override
    public String getdescription() {
     
        return pizza.getdescription()+ ", Olives";
    }
    @Override
    public int getamount() {
        return pizza.getamount()+ 1;
    }

}

class Mashrooms extends PizzaDecorator{

    public Mashrooms(Pizza pizza){
        super(pizza);
    }

     @Override
    public String getdescription() {
      
        return pizza.getdescription()+ ", Mashroom";
    }
    @Override
    public int getamount() {
       
        return pizza.getamount()+ 3;
    }
}

class Cheese extends PizzaDecorator{

    public Cheese(Pizza pizza){
        super(pizza);
    }

     @Override
    public String getdescription() {
        
        return pizza.getdescription()+ ", Cheese";
    }
    @Override
    public int getamount() {
       
        return pizza.getamount()+ 2;
    }
}
public class Decorator {
    public static void main(String[] args) {
        Pizza pizza=new Basic();
        pizza= new Cheese(pizza);
        pizza= new Olives(pizza);
        System.out.println(pizza.getamount());

    }    
} 
