package com.codedotorg;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) {
        ArrayList<Product> products = Store.createStarterProducts();        
        ShoppingCartApp cart = new ShoppingCartApp(products);
        cart.startApp(primaryStage);
    }

}