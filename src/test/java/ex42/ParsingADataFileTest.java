package ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class ParsingADataFileTest {
    ParsingADataFile app = new ParsingADataFile();
    List<Employee> employeeListTEST = fillEmployeeList();
    List<Employee> fillEmployeeList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Scooby", "Doo", "scoobysnacks"));
        list.add(new Employee("Daphne", "Blake", "10000"));
        list.add(new Employee("Velma", "Dinkley", "18500"));
        list.add(new Employee("Shaggy", "Rogers", "9500"));
        list.add(new Employee("Fred", "Lastname", "10000"));
        return list;
    }

    @Test @DisplayName("printoutput hardcoded scoob")
    void printOutput() {
        app.printOutput(employeeListTEST);
    }

    @Test @DisplayName("main but breaks")
    void printOutput2(){
        try {
            app.printOutput(app.convertInput(app.readFromFile("ex42/testinput.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("I actually dont know how this exception thing works");
            e.printStackTrace();
        }
    }
    @Test @DisplayName("main but works")
    void printOutput3(){
        try {
            app.printOutput(app.convertInput(app.readFromFile("src/test/java/ex42/testinput.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("I actually dont know how this exception thing works");
            e.printStackTrace();
        }
    }

    @Test@DisplayName("convert reporoot testfile")
    void convertInput(){
        try {
            app.convertInput(app.readFromFile("src/test/java/ex42/testinput.txt"));
            System.out.println("Successfully converted.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test@DisplayName("convert srcroot testfile BREAK")
    void convertInput2(){
        try {
            app.convertInput(app.readFromFile("ex42/testinput.txt"));
            System.out.println("Successfully converted.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test @DisplayName("readfromtestfile reporoot?")
    void readFromFile(){
        try {
            System.out.print(app.readFromFile("src/test/java/ex42/testinput.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test @DisplayName("readfromtestfile srcroot? BREAK")
    void readFromFile2(){
        try {
            System.out.print(app.readFromFile("ex42/testinput.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}