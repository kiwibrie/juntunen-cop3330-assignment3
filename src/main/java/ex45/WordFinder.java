package ex45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFinder {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        WordFinder app = new WordFinder();

        String input_path = "src/main/java/ex45/exercise45_input.txt";

        //read input
        List<String> msg = app.readFromFile(input_path);

        //find and replace utilize with use
        msg = app.replaceText(msg, "utilize", "use");

        //prompt for output file name
        String filename = app.promptString();

        //print new text to output file
        app.writeToFile(filename, msg);

    }

    public void writeToFile(String path, List<String> msg){
        try{
            File file = new File(path);
            FileWriter filewriter = new FileWriter(file);
            for(int i = 0; i < msg.size(); i++){
                filewriter.write(msg.get(i) +" ");
            }
            filewriter.close();

        } catch (IOException e){
            System.out.println("No file to output to.");
        }
    }

    public String promptString(){
        System.out.print("What is the name of the .txt file to be made? ");
        return "src/main/java/ex45/" + in.next() + ".txt";
    }

    public List<String> readFromFile(String path) {
        List<String> msg = new ArrayList<>();
        File input_file = new File(path);
        try{
            Scanner in = new Scanner(input_file);
            while (in.hasNext()){
                msg.add(in.next());
            }
            in.close();
        } catch (IOException e){
            System.out.println("Invalid text file.");
        }
        return msg;
    }

    public List<String> replaceText(List<String> fulltext, String find, String replace){
        for(int i = 0; i < fulltext.size(); i++){
            if(fulltext.get(i).contains(find)){
                if(fulltext.get(i).contains(find+"s")){
                    fulltext.set(i, replace+"s");
                } else {
                    fulltext.set(i, replace);
                }
            }
        }
        return fulltext;
    }
}
