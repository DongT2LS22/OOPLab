package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> ListofAuthors = new ArrayList<String>();

    public Book(int id,String title,String category,float cost){
        super(id,title,category,cost);
    }
    public Book(int id, String title, String category, float cost, List<String> listofAuthors) {
        super(id, title, category, cost);
        ListofAuthors = listofAuthors;
    }
    public Book(String title, String category, float cost, List<String> authors) {
        super();
        this.setId(getCurrentId());
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.ListofAuthors = authors;
    }

    public List<String> getListofAuthors() {
        return ListofAuthors;
    }

    public void setListofAuthors(List<String> ListofAuthors) {
        this.ListofAuthors = ListofAuthors;
    }

    public void addAuthor(String authorName){
        int check = 0;
        for( String author : ListofAuthors){
            if( author.equals(authorName)){
                check = 1;
            }
        }
        if( check == 1){
            System.out.println("Error!!!");
        }else{
            ListofAuthors.add( authorName);
            System.out.println("Success!!!");
        }
    }
    public void removeAuthor(String authorName){

        int check = 0;
        int length = ListofAuthors.size();
        for( int i = 0; i < length; ++i){
            if( ListofAuthors.get(i).equals(authorName)){
                ListofAuthors.remove( ListofAuthors.get(i));
                System.out.println("Success!!!");
                check = 1;
                break;
            }
        }
        if (check == 0){
            System.out.println("Error");
        }

    }
    @Override
    public String toString() {
        return this.getId() + ".DVD - " + this.getTitle() + " - "
                + this.getCategory() + " : " +
                +this.getCost();
    }
    public static void main(String[] args) {
        
    }
}
