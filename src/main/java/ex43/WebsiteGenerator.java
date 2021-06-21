package ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        WebsiteGenerator app = new WebsiteGenerator();

        //prompt for the name of the site
        String sitename = app.promptString("Site name: ");
        //prompt for the author of the site
        String author = app.promptString("Author: ");
        //ask for javascript folder
        boolean js = app.promptBool("JavaScript");
        //ask for css folder
        boolean css = app.promptBool("CSS");

        //generate all desired files
        app.createWebsite(sitename, author, js, css);

    }

    public String promptString(String prompt){
        System.out.print(prompt);
        return in.nextLine();
    }

    public boolean promptBool(String prompt){
        System.out.print("Do you want a folder for "+prompt+"? ");
        return in.nextLine().equalsIgnoreCase("y");
    }

    public void createWebsite(String sitename, String author,
                              boolean js, boolean css){
        Website site = new Website(sitename, author);
        try{
            if(js){
                site.generateJSFolder();
            }
            if(css){
                site.generateCSSFolder();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
