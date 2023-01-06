package Screen;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.Media;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart){
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Screen/fxml/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }




    public static void main(String[] args) {
        List<String> storeList = new ArrayList<String>();
        storeList.add("Dong Pham");
        Media book = new Book(1, "Hello world", "Truyen Tranh", (float) 10.00, storeList);
        Media book1 = new Book(1, "Hello world", "Truyen Kiem Hiep", (float) 10.00, storeList);
        Media book2 = new Book(1, "Hello world", "Truyen Tranh 1", (float) 10.00, storeList);
        Media book3 = new Book(1, "Hello world", "Truyen Tranh 2", (float) 10.00, storeList);
        Media book4 = new Book(1, "Hello world", "Truyen Tranh 3", (float) 10.00, storeList);


        Cart cart = new Cart();
        cart.addMedia(book);
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(book4);
        new CartScreen(cart);
    }

}
