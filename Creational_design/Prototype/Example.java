package Creational_design.Prototype;

interface Prototype extends Cloneable{
    Prototype clone();
    void display();
    void setModel(String model);
    void setColor(String color);
    void setEngine(String engine);


}

class Car implements Prototype{
    private String model;
    private String color;
    private String engine;

    public Car(String model,String color,String engine){
        this.model=model;
        this.color=color;
        this.engine=engine;
    }

    public Prototype clone(){
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException  e) {
            // TODO: handle exception
            return new Car(this.model,this.color,this.engine);
        }
    } 
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Car - Model: " + model + ", Color: " + color + ", Engine: " + engine);
    }
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    }

    
class CarClient {
    private Prototype CarPrototype;

    public CarClient(Prototype CarPrototype){
        this.CarPrototype= CarPrototype;
    }

    public Prototype createcar(){
        return CarPrototype.clone();
    }

    public Prototype createcstmcar(String model,String color,String engine){
        Prototype Cstmcar= CarPrototype.clone();

        Cstmcar.setColor(color);
        Cstmcar.setEngine(engine);
        Cstmcar.setModel(model);
        return Cstmcar;
    }
}


public class Example {

    public static void main(String[] args) {
        System.out.println("orginal object creation");
        Prototype Proto= new Car("Model S", "Red", "Electric");

        System.out.println("=== Client Creation===");
        CarClient Client= new CarClient(Proto);
        
        Prototype car1=Client.createcar();
        Prototype car2=Client.createcar();
        Prototype car3=Client.createcstmcar("MOdel M", "Blue","Hybrid" );
        Prototype car4=Client.createcar();

        Proto.display();
        car3.display();
        car3.setColor("green");
        car3.display();
        car4.display();
    }
  
}