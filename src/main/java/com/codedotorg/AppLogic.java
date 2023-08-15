package com.codedotorg;

import java.util.ArrayList;

public class AppLogic {

    /** The store containing the products */
    private Store store;

    /** The shopping cart of selected products */
    private ShoppingCart cart;

    /**
     * Constructs an instance of AppLogic with the given list of products.
     * Initializes a new Store object with the given list of products and a new empty ShoppingCart object.
     *
     * @param products the list of products to be used in the store
     */
    public AppLogic(ArrayList<Product> products) {
        store = new Store(products);
        cart = new ShoppingCart();
    }

    /**
     * Returns the Store object associated with this AppLogic instance.
     *
     * @return the Store object associated with this AppLogic instance
     */
    public Store getStore() {
        return store;
    }

    /**
     * Returns the shopping cart object.
     *
     * @return the shopping cart object
     */
    public ShoppingCart getShoppingCart() {
        return cart;
    }
    
    /**
     * Adds the selected product to the cart.
     * Gets the selected product from the store's products list view and updates
     * the inventory and products list view. Then adds the selected product to
     * the cart and updates the cart's items list view.
     */
    public void addProductToCart() {
        Product selectedProduct = store.getProductsListView().getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            store.updateInventory(selectedProduct);
            store.updateProductsListView();

            cart.addToCart(selectedProduct);
            cart.updateItemsListView();
        }
    }

    /**
     * Removes the selected product from the cart.
     * Gets the selected product from the store's products list view and updates
     * the inventory and products list view. Then removes the selected product
     * from the cart and updates the cart's items list view.
     */
    public void removeProductFromCart() {
        Product selectedProduct = store.getProductsListView().getSelectionModel().getSelectedItem();





    }

    /**
     * Returns the new total of all products in the cart
     *
     * @return the new total of all products in the cart
     */
    public double getNewTotal() {

        
        return 0.0;
    }

}
