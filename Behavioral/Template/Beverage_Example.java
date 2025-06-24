package Behavioral.Template;

abstract class Beverage{

    final void prepare(){
        boilwater();
        brew();
        pourinCup();
        addCondiments();

    }
    private void boilwater() {
        System.out.println("boling water");
    }

    protected abstract void brew();

    private void pourinCup() {
        System.out.println("adding to cup..");
    }

    protected abstract void addCondiments();


    
}

class Coffee extends Beverage{

    @Override
    protected void brew() {
        // TODO Auto-generated method stub
       System.out.println(" adding coffe beans and brewing");
    }

    @Override
    protected void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println(" adding creamer and milk");
    }
}

class Tea extends Beverage{

    @Override
    protected void brew() {
        // TODO Auto-generated method stub
       System.out.println(" adding tea powder and brewing");
    }

    @Override
    protected void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println(" adding sugar and milk");
    }
}


public class Beverage_Example {

    public static void main(String[] args) {
        Coffee coffee= new Coffee();

        coffee.prepare();
    }
}
