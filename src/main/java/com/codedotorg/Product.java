package com.codedotorg;

public class Product {
    
    /** The name of the product */
    private String name;

    /** The price of the product */
    private double price;

    /**
     * Constructs a new Product object with the given name and price.
     *
     * @param name the name of the product
     * @param price the price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     * 
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the product, including its name and price.
     * 
     * @return a string representation of the product, including its name and price.
     */
    public String toString() {
        return name + " - $" + price;
    }

}
