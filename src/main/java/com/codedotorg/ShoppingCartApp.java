package com.codedotorg;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ShoppingCartApp {

    private Stage window;
    private Store store;
    private ShoppingCart cart;
    private Button addButton;
    private Button removeButton;
    private Label totalLabel;

    public ShoppingCartApp(ArrayList<Product> products) {
        this.store = new Store(products);
        this.cart = new ShoppingCart();
        this.addButton = new Button("Add to Cart");
        this.removeButton = new Button("Remove from Cart");
        this.totalLabel = new Label("Total: $0.00");
    }
    
    public void startApp(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Binary Bazaar");

        setAddButtonAction();
        setRemoveButtonAction();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.getChildren().addAll(store.getProductsListView(), addButton, cart.getItemsListView(), removeButton, totalLabel);

        Scene scene = new Scene(vbox, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void setAddButtonAction() {
        addButton.setOnAction(event -> {
            Product selectedProduct = store.getProductsListView().getSelectionModel().getSelectedItem();

            if (selectedProduct != null) {
                store.updateInventory(selectedProduct);
                store.updateProductsListView();

                cart.addToCart(selectedProduct);
                cart.updateItemsListView();

                updateTotal();
            }
        });
    }

    private void setRemoveButtonAction() {
        removeButton.setOnAction(e -> {
            


            
        });
    }

    private void updateTotal() {
        double total = 0.0;
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

}
