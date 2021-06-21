package ex41;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;
public class NameSorter {

    public static void main(String[] args) throws IOException {
        NameSorter app = new NameSorter();

        //read the file, line by line, inserting into an array
        //close input file
        String path = "src/main/resources/exercise41_input.txt";
        List<String> names = app.readFromFile(path);

        //sort array, return sorted array
        names = app.sortList(names);

        //print array to output file
        //close file
        app.writeToFile("src/main/java/ex41/exercise41_output.txt", names);
    }

    public List<String> readFromFile(String path) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        File input_file = new File(path);
        Scanner in = new Scanner(input_file);

        while (in.hasNextLine()){
            list.add(in.nextLine());
        }
        in.close();
        return list;
    }

    public void writeToFile(String path, List<String> array) throws IOException {
        FileWriter output_file = new FileWriter(path);
        output_file.write("Total of "+array.size()+" names.\n");
        output_file.write("------------------\n");
        for(int i = 0; i < array.size(); i++){
            output_file.write(array.get(i)+"\n");
        }
        output_file.close();
    }

    public List<String> sortList(List<String> input_array){
        for(int i = 0; i < input_array.size()-1; i++){
            for(int j = i+1; j < input_array.size(); j++){
                if(input_array.get(i).compareTo(input_array.get(j))>0){
                    String temp = input_array.get(i);
                    input_array.set(i, input_array.get(j));
                    input_array.set(j, temp);
                }
            }
        }
        return input_array;
    }
}
