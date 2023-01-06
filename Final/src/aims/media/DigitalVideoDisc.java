package aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public int getnbDigitalVideoDiscs() {
    	return nbDigitalVideoDiscs;
    }

    @Override
    public String toString() {
        return this.getId() + ".DVD - " + this.getTitle() + " - "
                + this.getCategory() + " - " +
                this.getDirector() + " - " + this.getLength() + " : " +
                +this.getCost();
    }

    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public static void main(String[] args) {
        Media a = new DigitalVideoDisc(1,"Hello","Hay",(float)10.00,10,"DOng");
        System.out.println(a.toString());
    }
}
