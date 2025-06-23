package Structural_Design.Proxy_Design;

interface Image{
    
    void display();
}

class RealImage implements Image{
    private String filename;
  
    public RealImage(String filename){
        this.filename=filename;
        loadImage();
    }

    private void loadImage(){
        System.out.println("Loading " + filename);
      
      	try {
        	Thread.sleep(200);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
   
    }
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(filename);
    }

}

class ProxyImage implements Image {

  private RealImage realImage;
  private String filename;
  
    public ProxyImage(String filename){
        this.filename=filename;
    }

    
    @Override
    public void display() {
        // TODO Auto-generated method stub
        if(realImage==null){
            realImage= new RealImage(filename);
        }
        realImage.display();
    }

    
}

public class ImageExample {
    public static void main(String[] args) {
        //instead of loading image directly we will have to load image through procy when ever we want to display real image
        Image image1=new ProxyImage("Load.jpg");
        image1.display();
    }
    
}
