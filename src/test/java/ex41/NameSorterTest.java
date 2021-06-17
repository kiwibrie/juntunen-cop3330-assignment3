package ex41;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {
    NameSorter app = new NameSorter();

    @Test
    @DisplayName("read from file good")
    void test1() throws FileNotFoundException {
        System.out.print(app.readFromFile("src/main/java/ex41/exercise41_input.txt"));
    }
    @Test@DisplayName("read from nonexistent file")
    void test2() throws FileNotFoundException{
        try{
            System.out.print(app.readFromFile("src/main/java/ex41/exercise41_inputTEST.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("write to file good")
    void test3() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("Doo, Scooby"); list.add("Jones, Fred"); list.add("Dinkley, Velma");
        list.add("Doo, Scrappy"); list.add("Rogers, Shaggy"); list.add("Blake, Daphne");
        app.writeToFile("src/main/java/ex41/exercise41_output.txt", list);
    }
    @Test
    @DisplayName("write to nonexistent file") //should create a file
    void test4() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("Doo, Scooby"); list.add("Jones, Fred"); list.add("Dinkley, Velma");
        list.add("Doo, Scrappy"); list.add("Rogers, Shaggy"); list.add("Blake, Daphne");
        app.writeToFile("src/main/java/ex41/exercise41_outputTEST.txt", list);
    }

    @Test
    @DisplayName("sortList regular names")
    void test5() {
        List<String> list = new ArrayList<>();
        list.add("Doo, Scooby"); list.add("Jones, Fred"); list.add("Dinkley, Velma");
        list.add("Doo, Scrappy"); list.add("Rogers, Shaggy"); list.add("Blake, Daphne");
        System.out.print(app.sortList(list));
    }
    @Test
    @DisplayName("sortList similar names")
    void test6() {
        List<String> list = new ArrayList<>();
        list.add("AAA, aaa"); list.add("AAa, AAa"); list.add("aaa, aaa");
        list.add("aaa, AAA"); list.add("aAA, aAA"); list.add("aBc, AbC");
        System.out.print(app.sortList(list));
    }

}