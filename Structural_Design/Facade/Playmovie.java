package Structural_Design.Facade;
class DvdPlayer{
    public void on(){
        System.out.println("DVDplayer on");
    }
    public void play(String movie){
        System.out.println("Playing movie: "+ movie);
    }

}
class Amp{
    public void on(){
        System.out.println("Amplifier on");
    }
    public void setvolume(int volume){
        System.out.println("Volume set to :"+ volume);
    }
}
class Projector{
    public void on(){
        System.out.println("Projector on");
    }

    public void Widescreen(){
        System.out.println("Projector on Widescreen");
    }
}

class HomeTheater{
    private DvdPlayer dvd;
    private Amp amp;
    private Projector proj;
    public HomeTheater(DvdPlayer dvd,Amp amp, Projector proj){
        this.amp=amp;
        this.proj=proj;
        this.dvd=dvd;
    }
    public void Playmovie(String movie, int volume){
        System.out.println("Playing Movie .....");
        amp.on();
        amp.setvolume(volume);
        dvd.on();
        dvd.play(movie);
        proj.on();
        proj.Widescreen();
    }



} 
public class Playmovie {
    public static void main(String[] args) {
        Amp amp=new Amp();
        DvdPlayer dvd=new DvdPlayer();
        Projector proj = new Projector();
        HomeTheater home=new HomeTheater(dvd, amp, proj);
        home.Playmovie("Bahubali", 100);

    }
    
}
