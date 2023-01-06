package Screen;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.Media;
import aims.media.Playable;
import aims.store.Store;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setResizable(false);
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int length = mediaInStore.size();
        for (int i = 0; i < length; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        List<String> storeList = new ArrayList<String>();
        storeList.add("Dong Pham");
        Media book = new Book(1, "Hello world", "Truyen Tranh", (float) 10.00, storeList);
        Media book1 = new Book(1, "Hello world", "Truyen Kiem Hiep", (float) 10.00, storeList);
        Media book2 = new Book(1, "Hello world", "Truyen Tranh 1", (float) 10.00, storeList);
        Media book3 = new Book(1, "Hello world", "Truyen Tranh 2", (float) 10.00, storeList);
        Media book4 = new Book(1, "Hello world", "Truyen Tranh 3", (float) 10.00, storeList);


        ArrayList<Media> itemStore = new ArrayList<Media>();
        itemStore.add(book);
        itemStore.add(book1);
        itemStore.add(book2);
        itemStore.add(book3);
        itemStore.add(book4);

        Store a = new Store(itemStore);
        new StoreScreen(a);
    }

    public class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);
            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            container.add(new JButton("Add to cart"));
            if (media instanceof Playable) {
                container.add(new JButton("Play"));
            }
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
}
