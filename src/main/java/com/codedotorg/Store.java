package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.control.ListView;

public class Store {
    
    private ArrayList<Product> products;
    private ListView<Product> productsListView;

    public Store(ArrayList<Product> products) {
        this.products = products;
        this.productsListView = createProductsListView();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ListView<Product> getProductsListView() {
        return productsListView;
    }

    public void updateInventory(Product selectedProduct) {
        products.remove(selectedProduct);
    }

    public void updateProductsListView() {
        productsListView.getItems().clear();
        productsListView.getItems().addAll(products);
    }

    public static ArrayList<Product> createStarterProducts() {
        ArrayList<Product> temp = new ArrayList<Product>();

        temp.add(new Product("Apple iPhone 13 Pro", 999.00));
        temp.add(new Product("Apple iPhone 13 Pro", 999.00));
        temp.add(new Product("Google Pixel 6", 699.00));
        temp.add(new Product("Dell XPS 15", 1899.00));
        temp.add(new Product("Apple MacBook Pro", 2399.00));
        temp.add(new Product("Amazon Echo Dot", 49.00));
        temp.add(new Product("Apple AirPods Pro", 249.00));
        temp.add(new Product("Samsung 50in 4K UHD Smart TV", 549.00));
        temp.add(new Product("Bose QuietComfort 35 II", 349.00));
        temp.add(new Product("Apple iPad Pro", 1099.00));
        temp.add(new Product("Nikon D3500 DSLR Camera", 499.00));
        temp.add(new Product("PlayStation 5", 499.00));
        temp.add(new Product("Xbox Series X", 499.00));
        temp.add(new Product("Nintendo Switch", 299.00));
        temp.add(new Product("Instant Pot DUO60", 89.00));
        temp.add(new Product("Dyson V11 Torque Drive", 699.00));
        temp.add(new Product("Samsung Galaxy Tab S7", 649.00));
        temp.add(new Product("HP Envy 5055 Wireless Printer", 119.00));
        temp.add(new Product("Fitbit Charge 4", 149.00));
        temp.add(new Product("Sonos One", 199.00));

        return temp;
    }

    private ListView<Product> createProductsListView() {
        ListView<Product> tempListView = new ListView<Product>();
        tempListView.getItems().addAll(products);
        return tempListView;
    }

}
