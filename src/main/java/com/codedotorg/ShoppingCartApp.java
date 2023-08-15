package com.codedotorg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

public class ShoppingCartApp {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The list of products */
    private ArrayList<Product> products;

    /** The label displaying the total price of all products */
    private Label totalLabel;

    /** The logic for working with the store and shopping cart */
    private AppLogic logic;

    /**
     * Constructor for the ShoppingCartApp class.
     * 
     * @param window The main window of the application.
     * @param width The width of the main window.
     * @param height The height of the main window.
     * @param products The list of products available for purchase.
     */
    public ShoppingCartApp(Stage window, int width, int height, ArrayList<Product> products) {
        this.window = window;
        this.width = width;
        this.height = height;
        this.products = products;
        
        totalLabel = new Label("Total: $0.00");
        logic = new AppLogic(products);
    }
    
    /**
     * This method starts the shopping cart application by setting
     * the title of the window to "Binary Bazaar", creating the main
     * layout of the application, setting the scene to the main
     * layout, and displaying the window.
     */
    public void startApp() {
        window.setTitle("Binary Bazaar");

        VBox mainLayout = createMainLayout();

        Scene currentScene = new Scene(mainLayout, width, height);
        currentScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(currentScene);
        window.show();
    }

    /**
     * Creates a VBox layout with padding and spacing, and adds the
     * components created by the createComponents method to it.
     * 
     * @return the VBox layout with the components added to it.
     */
    public VBox createMainLayout() {
        VBox tempLayout = new VBox();
        tempLayout.setPadding(new Insets(10));
        tempLayout.setSpacing(8);

        List<Node> componentsList = createComponents();

        tempLayout.getChildren().addAll(componentsList);

        return tempLayout;
    }

    /**
     * Creates a list of UI components for the shopping cart application.
     * The list includes a ListView of products, an "Add" button, a ListView of items in the shopping cart,
     * a "Remove" button, and a label displaying the total cost of the items in the shopping cart.
     *
     * @return a List of Node objects representing the UI components
     */
    public List<Node> createComponents() {
        Button addButton = createAddButton();
        Button removeButton = createRemoveButton();

        List<Node> componentsList = Arrays.asList(
            logic.getStore().getProductsListView(),
            addButton,
            logic.getShoppingCart().getItemsListView(),
            removeButton,
            totalLabel
        );

        return componentsList;
    }

    /**
     * Creates a button with the text "Add to Cart" and sets an action
     * to add the product to the cart and update the total label.
     * 
     * @return the created button
     */
    public Button createAddButton() {
        Button tempButton = new Button("Add to Cart");

        tempButton.setOnAction(event -> {
            logic.addProductToCart();
            totalLabel.setText(String.format("Total: $%.2f", logic.getNewTotal()));
        });

        return tempButton;
    }

    /**
     * Creates a button that removes a product from the
     * shopping cart and updates the total label.
     * 
     * @return the remove button
     */
    public Button createRemoveButton() {
        Button tempButton = new Button("Remove from Cart");

        tempButton.setOnAction(e -> {
            logic.removeProductFromCart();
            totalLabel.setText(String.format("Total: $%.2f", logic.getNewTotal()));
        });

        return tempButton;
    }

}
