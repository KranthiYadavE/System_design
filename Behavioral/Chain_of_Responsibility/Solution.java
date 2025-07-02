package Behavioral.Chain_of_Responsibility;

abstract class SupportHandler{
    protected SupportHandler nextSupportHandler;

    public void setnextHandler(SupportHandler supportHandler){
        this.nextSupportHandler=supportHandler;
    }
    public abstract void handlerequest(String prority);

}

class SupportAgent extends SupportHandler{

    @Override
    public void handlerequest(String priority) {
        if(priority.equals("low")){
            System.out.println("Support is handling request");
        }
        else{
            nextSupportHandler.handlerequest(priority);
        }
    }
    
}

class Supervisor extends SupportHandler{

    @Override
    public void handlerequest(String priority) {
        if(priority.equals("medium")){
            System.out.println("Supervisor is handling request");
        }
        else{
            nextSupportHandler.handlerequest(priority);
        }
    }
    
}

class Manager extends SupportHandler{

    @Override
    public void handlerequest(String priority) {
        if(priority.equals("high")){
            System.out.println("Manager is handling request");
        }else{
            System.out.println("Invalid Request");
        }
    }
    
}

public class Solution {
    public static void main(String[] args) {
        SupportHandler supportagent= new SupportAgent();
        SupportHandler supervisor= new Supervisor();
        SupportHandler Manager= new Manager();
        supportagent.setnextHandler(supervisor);
        supervisor.setnextHandler(Manager);
        supportagent.handlerequest("medium");
        supportagent.handlerequest("low");
        supportagent.handlerequest("high");
    }
}
