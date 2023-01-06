package aims.media;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CompactDisc extends Disc implements Playable{

    private String artist;

    private ArrayList<Track> Tracks;

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        Tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if(!this.Tracks.contains(track))this.Tracks.add(track);
        else{
            System.out.println("Incorrect !!!");
        }
    }

    public void removeTrack(Track track){
        if(this.Tracks.contains(track))this.Tracks.remove(track);
        else{
            System.out.println("Incorrect !!!");
        }
    }

    public int getLength(){
        AtomicInteger lengthofCD = new AtomicInteger();
        Tracks.forEach((element)->{
            lengthofCD.addAndGet(element.getLength());
        });
        return lengthofCD.get();
    }

    @Override
    public void play() {
        this.Tracks.forEach((element)->{
            element.play();
        });

    }

    @Override
    public String toString() {
        return this.getId() + ".DVD - " + this.getTitle() + " - "
                + this.getCategory() + " - " +
                this.getDirector() + " - "  + this.getArtist() + " - " + this.getLength() + " : " +
                +this.getCost();
    }
}
