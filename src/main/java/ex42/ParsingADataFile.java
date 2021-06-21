package ex42;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParsingADataFile {

    public static void main(String[] args){
        ParsingADataFile app = new ParsingADataFile();

        List<String> input = null;
        try {
            //open file
            //read file, adding each line to a list
            //close file
            String path = "src/main/resources/exercise42_input.txt";
            input = app.readFromFile(path);

            //take in inputlist
            //convert each line to a list of employees
            //return employeelist
            List<Employee> employeeList = app.convertInput(input);

            //print employee data by iterating through list
            app.printOutput(employeeList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void printOutput(List<Employee> list){
        System.out.printf("%-10s %-10s %-10s\n", "Last", "First", "Salary");
        System.out.print("----------------------------\n");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-10s %-10s %-10s\n", list.get(i).lastname,
                    list.get(i).firstname, list.get(i).salary);
        }
    }

    public List<Employee> convertInput(List<String> input_list){
        List<Employee> list = new ArrayList<>();

        for(int i = 0; i < input_list.size(); i++){
            String[] ncdata = input_list.get(i).split(",");
            Employee x = new Employee(ncdata[1], ncdata[0], ncdata[2]);
            list.add(x);
        }
        return list;
    }

    public List<String> readFromFile(String path) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        File input_file = new File(path);
        Scanner in = new Scanner(input_file);

        while(in.hasNext()){
            list.add(in.nextLine());
        }
        return list;
    }
}

