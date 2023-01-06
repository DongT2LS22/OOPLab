package Screen;

import aims.cart.Cart;
import aims.media.Media;
import aims.media.Playable;
import aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;

public class CartScreenController {

    private Cart cart;



    @FXML
    private BorderPane root;



    @FXML
    private TextField tfFilter;



    @FXML
    private RadioButton radioBtnFilterId;



    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;



    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediacategory;



    @FXML
    private TableView<Media> tblMedia;



    @FXML
    private TableColumn<Media, Float> colMediaCost;



    @FXML
    private ToggleGroup filterCategory;



    @FXML
    private TableColumn<Media, String> colMediaTitle;



    @FXML
    private Label totalCost;





    public CartScreenController(Cart cart){
        this.cart = cart;
    }



    @FXML
    public void initialize(){
        colMediaTitle.setCellValueFactory( new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory( new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory( new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems( this.cart.getItemsOrdered());
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>(){
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media media, Media t1) {
                        if( t1 != null){
                            updateButtonBar(t1);
                        }
                    }
                    private void updateButtonBar(Media t1) {
                        btnRemove.setVisible( true);
                        if( t1 instanceof Playable){
                            btnPlay.setVisible( true);
                        }else{
                            btnPlay.setVisible( false);
                        }
                    }
                }
        );

    }
    @FXML
    public void btnRemovePressed(ActionEvent event) {

    }




    @FXML
    void orderAction(ActionEvent event) {

    }
    @FXML
    public void viewStore(ActionEvent event) {

    }



    @FXML
    void addBook(ActionEvent event) {

    }



    @FXML
    void addCD(ActionEvent event) {

    }



    @FXML
    void addDVD(ActionEvent event) {

    }




    @FXML
    void btnPlayPressed(ActionEvent event) {

    }
}
