package aims.store;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
//import lab02.DigitalVideoDisc;

import aims.media.DigitalVideoDisc;
import aims.media.Media;
import java.util.Scanner;

public class Store {
	private static ArrayList<Media> itemsInStore = new ArrayList<Media>();

	//public store() {
	//	super();
	//}


	public Store(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	
	public void removeMedia(Media media) {
		
		// create an Iterator Object
		Iterator<Media> itr = itemsInStore.iterator();
		
		// hold true till there is single element remaining in object
		while(itr.hasNext()) {
			Media tmp = itr.next();
			
			// If equal by id, then remove
			if(tmp.getId() == media.getId()) {
				itr.remove();
			}
		}
	}

	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		int i;
		System.out.println("AIMS: ");

		System.out.println("--------------------------------");

		System.out.println("1. View store");

		System.out.println("2. Update store");

		System.out.println("3. See current cart");

		System.out.println("0. Exit");

		System.out.println("--------------------------------");

		System.out.println("Please choose a number: 0-1-2-3");
		i = input.nextInt();
		switch (i){
			case 1 : {
				storeMenu();
				break;
			}
			case 2: {
				break;
			}
			case 3:{
				cartMenu();
				break;
			}
		}
	}

	public static void storeMenu() {

		itemsInStore.forEach((element)->{
			System.out.println(element.toString());
		});
		Scanner input = new Scanner(System.in);
		int i;
		System.out.println("Options: ");

		System.out.println("--------------------------------");

		System.out.println("1. See a media’s details");

		System.out.println("2. Add a media to cart");

		System.out.println("3. Play a media");

		System.out.println("4. See current cart");

		System.out.println("0. Back");

		System.out.println("--------------------------------");

		System.out.println("Please choose a number: 0-1-2-3-4");
		i = input.nextInt();
		switch (i){
			case 0:{
				showMenu();
			}
			case 1:{
				mediaDetailsMenu();
				break;
			}
			case 2:
			case 3: {
				break;
			}

		}
	}

	public static void mediaDetailsMenu() {

		System.out.println("Options: ");

		System.out.println("--------------------------------");

		System.out.println("1. Add to cart");

		System.out.println("2. Play");

		System.out.println("0. Back");

		System.out.println("--------------------------------");

		System.out.println("Please choose a number: 0-1-2");
		Scanner input = new Scanner(System.in);
		int i;
		i = input.nextInt();
		switch (i){
			case 1:
			case 2: {
				break;
			}
			case 0:{
				storeMenu();
				break;
			}
		}
	}

	public static void cartMenu() {

		System.out.println("Options: ");

		System.out.println("--------------------------------");

		System.out.println("1. Filter medias in cart");

		System.out.println("2. Sort medias in cart");

		System.out.println("3. Remove media from cart");

		System.out.println("4. Play a media");

		System.out.println("5. Place order");

		System.out.println("0. Back");

		System.out.println("--------------------------------");

		System.out.println("Please choose a number: 0-1-2-3-4-5");

		Scanner input = new Scanner(System.in);
		int i;
		i = input.nextInt();
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
//	public void availableDVD() {
//		// create an Iterator Object
//		Iterator<DigitalVideoDisc> itr = itemsInStore.iterator();
//
//		while(itr.hasNext()) {
//			DigitalVideoDisc tmp = itr.next();
//
//			tmp.printDetail();
//		}
//	}
}
