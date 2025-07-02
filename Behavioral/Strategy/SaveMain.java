package Behavioral.Strategy;

interface SaveStrategy {
    public void save(String text);
}

class HTMLsave implements SaveStrategy{

    @Override
    public void save(String text) {
        System.out.println("<html>"+text+"</html>");
    }
    
}
class Plainsave implements SaveStrategy{

    @Override
    public void save(String text) {
        System.out.println("plain text :"+ text);
    }
    
}

class Document{
    private String text;
    private SaveStrategy saveStrategy;
    public Document(String text){
        this.text=text;
    }

    public void setSavesave(SaveStrategy saveStrategy){
        this.saveStrategy=saveStrategy;

    }
    public void save(){
        if(this.saveStrategy!=null){
            saveStrategy.save(this.text);
        }
        else{
            System.out.println("save stargtegy not set");
        }

    }
    
}


public class SaveMain {
public static void main(String[] args) {
    Document doc= new Document("Hi I am Java");
    doc.setSavesave(new HTMLsave());
    doc.save();
}
    
}
