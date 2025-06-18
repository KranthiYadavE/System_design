package Factory;

interface Delivery {
  void deliver();
    
}

class Truck implements Delivery{
    @Override
    public void deliver(){
        System.err.println("Truck delivery");
    }
}


class Ship implements Delivery{
    @Override
    public void deliver(){
        System.err.println("Ship  delivery");
    }
}

public class DeliveryService {
    public static void main(String[] args){
        Delivery TD=new Truck();
        Delivery SD = new Ship();
        TD.deliver();
        SD.deliver();
//voilates SR,OD principles
//its xreating objects and calling the delivery function
    }

    
}