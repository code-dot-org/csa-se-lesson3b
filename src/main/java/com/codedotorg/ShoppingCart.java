package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.control.ListView;

public class ShoppingCart {
    
    /** The list of products */
    private ArrayList<Product> items;

    /** The list view that displays the products */
    private ListView<Product> itemsListView;

    /**
     * Constructs a new ShoppingCart object with an empty list of items and a new ListView of Products.
     */
    public ShoppingCart() {
        items = new ArrayList<Product>();
        itemsListView = new ListView<Product>();
    }

    /**
     * Returns the list of items in the shopping cart.
     *
     * @return the list of items in the shopping cart
     */
    public ArrayList<Product> getItems() {
        return items;
    }

    /**
     * Returns the ListView of products in the shopping cart.
     *
     * @return the ListView of products in the shopping cart.
     */
    public ListView<Product> getItemsListView() {
        return itemsListView;
    }

    /**
     * Adds the selected product to the shopping cart.
     * 
     * @param selectedProduct the product to be added to the cart
     */
    public void addToCart(Product selectedProduct) {
        items.add(selectedProduct);
    }

    /**
     * Removes the selected product from the shopping cart.
     * 
     * @param selectedProduct the product to be removed from the cart
     */
    public void removeFromCart(Product selectedProduct) {
        items.remove(selectedProduct);
    }

    /**
     * Returns the currently selected product in the items list view.
     *
     * @return the selected product
     */
    public Product getSelectedProduct() {
        return itemsListView.getSelectionModel().getSelectedItem();
    }

    /**
     * Calculates the total price of all items in the shopping cart.
     *
     * @return the total price of all items in the shopping cart
     */
    public double getTotalPrice() {
        double total = 0.0;

        for (Product item : items) {
            total += item.getPrice();
        }

        return total;
    }

    /**
     * Updates the items list view by clearing the current
     * items and adding all items in the shopping cart.
     */
    public void updateItemsListView() {
        itemsListView.getItems().clear();
        itemsListView.getItems().addAll(items);
    }
    
}
