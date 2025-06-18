package Factory;
interface Delivery{

    public void deliver();
}

class Bike implements Delivery {
    @Override
    public void deliver(){
        System.out.println("Bike Delivery");

    }   
}

class Car implements Delivery {
    @Override
    public void deliver(){
        System.out.println("Car Delivery");

    }   
}

class Drone implements Delivery {
    @Override
    public void deliver(){
        System.out.println("Drone Delivery");

    }   
}

class DeliveryFactory{

    public static Delivery getDelivery(String type){

        switch(type.toLowerCase()){
            case "bike":
                return new Bike();
            case "drone":
                return new Drone();
            case "car":
                return new Car();
            default:
                throw new IllegalArgumentException("Delivery unkown");
        }
    }


}
public class DeliveryServiceF {
    public static void main(String[] args) {
        Delivery bikeDelivery = DeliveryFactory.getDelivery("Bike");
        Delivery carDelivery = DeliveryFactory.getDelivery("Car");
        Delivery droneDelivery = DeliveryFactory.getDelivery("Drone");
        bikeDelivery.deliver();
        carDelivery.deliver();
        droneDelivery.deliver();
    }
    
}
