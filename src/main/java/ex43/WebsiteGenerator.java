package ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.File;
import java.io.FileWriter;
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

class Website {
    String sitename;
    String author;
    String general_path;

    public Website(String sitename, String author) {
        this.sitename = sitename;
        this.author = author;
        this.general_path = "src/main/java/ex43/createdWebsites/website/" + sitename;

        try{
            generateSiteFolder();
            generateIndexFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateSiteFolder() throws IOException {
        File folder = new File(general_path);
        if(folder.mkdirs()){
            printCreation(general_path);
        }
    }

    public void generateIndexFile() throws IOException {
        String path = general_path + "/index.html";
        File file = new File(path);
        FileWriter filewriter = new FileWriter(file);
        filewriter.write("<title>"+sitename+"</title>\n" +
                "<meta author=\""+author+"\">");
        filewriter.close();
        printCreation(path);
    }

    public void generateJSFolder() throws IOException {
        String path = general_path + "/js/";
        File file = new File(path);
        if(file.mkdir()){
            printCreation(path);
        }
    }

    public void generateCSSFolder() throws IOException {
        String path = general_path + "/css/";
        File file = new File(path);
        if(file.mkdir()){
            printCreation(path);
        }
    }

    public void printCreation(String path){
        System.out.println("Created "+path);
    }
}