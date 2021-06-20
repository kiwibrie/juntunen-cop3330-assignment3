package ex44;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductSearch {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        ProductSearch app = new ProductSearch();

        String input_path = "src/main/java/ex44/exercise44_input.json";
        //create list from json file
        List<Product> inventory = app.createInventory(input_path);

        //prompt for product name
        //search for name
        //if not found, reprompt
        Product found = app.searchInventory(inventory);


        //else, print product information
        app.printOutput(found);
    }

    public void printOutput(Product item){
        System.out.printf("Name: %s\n", item.name);
        System.out.printf("Price: %s\n", item.price);
        System.out.printf("Quantity: %s\n", item.quantity);
    }

    public Product searchInventory(List<Product> inventory){
        while(true){
            String search_term = promptString();
            for(int i = 0; i < inventory.size(); i++){
                if(inventory.get(i).name.equalsIgnoreCase(search_term)){
                    return inventory.get(i);
                }
            }
            System.out.print("Sorry, that product was not found in our inventory.\n");
        }
    }

    public String promptString(){
        System.out.print("What is the product name? ");
        return in.nextLine();
    }

    public List<Product> createInventory(String path){
        Gson gson = new Gson();
        List<Product> list = new ArrayList<>();
        JsonArray array = new JsonArray();

        for(int i = 0; i < array.size(); i=i+3){
            Product x = new Product(gson.fromJson(array.get(i), String.class),
                    gson.fromJson(array.get(i+1), String.class),
                    gson.fromJson(array.get(i+2), String.class));
            list.add(x);
        }

        return list;
    }
}

class Product{
    String name;
    String price;
    String quantity;

    public Product(String name, String price, String quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
