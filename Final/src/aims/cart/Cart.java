package aims.cart;

import java.util.*;

import aims.media.DigitalVideoDisc;
import aims.media.Media;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Cart {
//	private int qtyOrdered = 0;
	private static final int MAX_NUMBERS_ORDERED = 20;
//	private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

//    public Cart(int qtyOrdered) {
//        this.qtyOrdered = qtyOrdered;
//    }

//    public int getqtyOrdered() {
//        return qtyOrdered;
//    }
	
	
//	public void setqtyOrdered(int qtyOrdered) {
//        this.qtyOrdered = qtyOrdered;
//    }
	
//	public void addDigitalVideoDisc(Media media) {
//        if (qtyOrdered < 20) {
//            itemsOrdered.add(media);
//            qtyOrdered ++;
//            System.out.println("The disc has been added");
//        } else System.out.println("The cart is almost full");
//    }
    public void addMedia( Media media){
        if( itemsOrdered.size() == MAX_NUMBERS_ORDERED){
            System.out.println("Cart full");
        }else{
    //            for( int i = 0; i < itemsOrdered.size(); ++i){
    //                if( itemsOrdered.get(i).equals( media)){
    //                    System.out.println("DVD exist");
    //                    return;
    //                }
    //            }
            if( itemsOrdered.contains(media)){
                System.out.println("Media exist");
                return;
            }
            itemsOrdered.add(media);
        }
    }
    public void removeMedia( Media media){
        if( itemsOrdered.contains( media)){
            itemsOrdered.remove( itemsOrdered.indexOf( media));
            System.out.println("Remove successfully");
        }else{
            System.out.println("DVD don't exist");
        }
    }


    public void printList(){
        float total = 0;
        for( Media media: itemsOrdered){
            System.out.println( media.toString());
            total += media.getCost();
        }
        System.out.println( "Total cost : " + total);
    }
    public void searchById( int id){
        for( Media media : itemsOrdered){
            if( media.getId() == id){
                System.out.println( media.toString());
                return;
            }
        }
        System.out.println("Not found");
    }

    public void searchByTitle(String title){
        int flag = 0;
        for( Media media : itemsOrdered){
            if( media.getTitle().equals( title)){
                System.out.println( media.toString());
                flag = 1;
            }
        }
        if( flag == 0){
            System.out.println("Not found");
        }
    }

    public ObservableList<Media> filteredById(String Id) {
        if(Id.equals("")) return null;
        int id = Integer.parseInt(Id);
        ObservableList<Media> filteredItems =
                FXCollections.observableArrayList();
        for(int i=0;i<itemsOrdered.size();i++) {
            if(id==itemsOrdered.get(i).getId()) {
                filteredItems.add(itemsOrdered.get(i));
            }
        }
        return filteredItems;
    }

    public ObservableList<Media> filteredByTitle(String Id) {
        ObservableList<Media> filteredItems =
                FXCollections.observableArrayList();
        if(Id.equals("")) return itemsOrdered;
        for(int i=0;i<itemsOrdered.size();i++) {
            if(itemsOrdered.get(i).getTitle().contains(Id)) {
                filteredItems.add(itemsOrdered.get(i));
            }
        }
        return filteredItems;
    }
    public void sortByTitleCost(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_COST_TITLE );
    }
//
//	public String addDigitalVideoDisc(List<DigitalVideoDisc> discList) {
//		if(discList.size() + qtyOrdered <=20) {
//			for(DigitalVideoDisc disc: discList) {
//				this.addDigitalVideoDisc(disc);
//			}
//			return "This disc has been added";
//		}else {
//			return "This cart is almost full";
//		}
//	}
//
//	public String addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
//        if (qtyOrdered +2 < 20) {
//            this.addDigitalVideoDisc(disc1);
//            this.addDigitalVideoDisc(disc2);
//            return "The disc has been added";
//        } else return "The cart is almost full";
//    }
//
//
//	public void removeDigitalVideoDisc(Media media) {
//        int count = qtyOrdered;
//        if(this.itemsOrdered.contains(media)){
//            this.itemsOrdered.remove(media);
//        }
//        else System.out.println("Can't found item.");
//    }

//	public double totalCost() {
//        if (qtyOrdered <= 0) return 0;
//        double cost = 0;
//        for (Media item: itemsOrdered)
//        {
//            cost+=item.getCost();
//        }
//
//        return cost;
//    }
//
    public float totalCost(){
        float total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
//	public void displayCart() {
//		System.out.println();
//		if (qtyOrdered <= 0) System.out.println("Nothing");
//		else {
//			for (int i = 0; i < qtyOrdered; i++) {
//				itemsOrdered[i].printDetail();
//			}
//		}
//	}
//
//	public void printCart() {
//        System.out.println("********************CART***********************\nOrdered Items:");
//        double total = 0;
//        for (int i = 0; i < qtyOrdered; i++) {
//            total += this.itemsOrdered[i].getCost();
//            System.out.println(this.itemsOrdered[i].getId() + ".DVD - " + this.itemsOrdered[i].getTitle() + " - "
//                    + this.itemsOrdered[i].getCategory() + " - " +
//                    this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + " : " +
//                    +this.itemsOrdered[i].getCost());
//        }
//        System.out.println("Total Cost : " + total);
//        System.out.println("*********************************************");
//
//    }
	
	
}
