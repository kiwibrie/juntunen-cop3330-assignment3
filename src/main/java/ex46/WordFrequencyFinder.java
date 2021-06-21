package ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordFrequencyFinder {

    public static void main(String[] args) {
        WordFrequencyFinder app = new WordFrequencyFinder();

        String path = "src/main/java/ex46/exercise46_input.txt";

        //read from file, dump into list
        List<String> fulltext = app.readFromFile(path);

        //search files for keywords
        List<Keyword> keywords = app.generateKeyList(fulltext);
        //sort keywords by frequency
        List<Keyword> sortedKeywords = app.sortKeyList(keywords);

        //print histogram of list
        app.printOutput(sortedKeywords);

    }

    public void printOutput(List<Keyword> list){
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-10s", list.get(i).word +":");
            for(int j = 0; j < list.get(i).frequency; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public List<String> readFromFile(String path) {
        List<String> text = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNext()) {
                text.add(in.next());
            }
            in.close();
        } catch (IOException e) {
            System.out.print("Invalid file path.");
            System.exit(0);
        }
        return text;
    }

    public List<Keyword> generateKeyList(List<String> text) {
        List<Keyword> list = new ArrayList<>();
        Keyword first = new Keyword(text.get(0), 1);
        list.add(first);

        for(int i = 0; i < text.size(); i++){
            if(!existsInList(list, text.get(i))){
                Keyword x = new Keyword(text.get(i), 1);
                list.add(x);
            } else {
                list.get(getIndex(list, text.get(i))).frequency++;
            }
        }
        return list;
    }

    public int getIndex(List<Keyword> list, String word){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).word.equals(word)){
                return i;
            }
        }
        return -1;
    }

    public boolean existsInList(List<Keyword> list, String word){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).word.equals(word)){
                return true;
            }
        }
        return false;
    }

    public List<Keyword> sortKeyList(List<Keyword> list){
        list.sort(Comparator.comparing(Keyword::getFrequency).reversed());
        return list;
    }
}

class Keyword{
    String word;
    int frequency;

    public Keyword(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}

