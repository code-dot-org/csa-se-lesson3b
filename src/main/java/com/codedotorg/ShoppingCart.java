package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.control.ListView;

public class ShoppingCart {
    
    private ArrayList<Product> items;
    private ListView<Product> itemsListView;

    public ShoppingCart() {
        items = new ArrayList<Product>();
        itemsListView = new ListView<Product>();
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public ListView<Product> getItemsListView() {
        return itemsListView;
    }

    public void addToCart(Product selectedProduct) {
        items.add(selectedProduct);
    }

    public void removeFromCart(Product selectedProduct) {
        items.remove(selectedProduct);
    }

    public Product getSelectedProduct() {
        return itemsListView.getSelectionModel().getSelectedItem();
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (Product item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public void updateItemsListView() {
        itemsListView.getItems().clear();
        itemsListView.getItems().addAll(items);
    }
    
}
