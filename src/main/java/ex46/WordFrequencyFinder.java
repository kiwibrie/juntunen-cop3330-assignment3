package ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordFrequencyFinder {

    public static void main(String[] args){
        WordFrequencyFinder app = new WordFrequencyFinder();

        String path = "src/main/java/ex46/exercise46_input.txt";
        //read from file, dump into list

        List<String> fulltext = app.readFromFile(path);

        //search files for keywords
        //create counters for each keyword
        Map<String, Integer> frequencies = app.searchText(fulltext);
        Map<String, Integer> freq2 = frequencies;
        String[] keywords = app.createKeyList(frequencies);

        //print histogram
        //loop: find most frequent word, print, remove
        app.printOutput(keywords, freq2);

    }

    public List<String> readFromFile(String path){
        List<String> text = new ArrayList<>();
        try{
            File file = new File(path);
            Scanner in = new Scanner(file);

            while (in.hasNext()){
                text.add(in.next());
            }
            in.close();
        } catch (IOException e){
            System.out.print("Invalid file path.");
            System.exit(0);
        }
        return text;
    }

    public Map<String, Integer> searchText(List<String> text){
        Map<String, Integer> keyword = new HashMap<>();
        for(int i = 0; i < text.size(); i++){
            String scanned_word = text.get(i);
            if(!keyword.containsKey(scanned_word)){
                keyword.put(text.get(i), 1);
            } else {
                keyword.put(scanned_word, keyword.get(scanned_word)+1);
            }
        }
        return keyword;
    }

    public void printOutput(String[] keyword, Map<String, Integer> map){
        for(int i = 0; i < keyword.length; i++){
            System.out.printf("%-10s", keyword[i]+":");
            for(int j = 0; j < map.get(keyword[i]); j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }


    public String[] createKeyList(Map<String, Integer> map){
        int words = map.size();
        String[] array = new String[words];
        for(int i = 0; i < words; i++){
            array[i] = findMostFrequent(map);
        }
        return array;
    }

    public String findMostFrequent(Map<String, Integer> map){
        Map.Entry<String, Integer> entryWithMaxValue = null;

        for (Map.Entry<String, Integer> currentEntry : map.entrySet()) {

            if (entryWithMaxValue == null ||
                    currentEntry.getValue().compareTo
                            (entryWithMaxValue.getValue()) > 0) {
                entryWithMaxValue = currentEntry;
            }
        }
        assert entryWithMaxValue != null;
        String key = entryWithMaxValue.getKey();
        map.remove(key);
        return key;
    }
}
