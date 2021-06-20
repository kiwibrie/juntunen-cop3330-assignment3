package ex45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordFinderTest {
    WordFinder app = new WordFinder();

    @Test
    @DisplayName("reading file test")
    void test1(){
        List<String> msg = app.readFromFile("src/main/java/ex45/exercise45_input.txt");
        System.out.print(msg);
    }

    @Test
    @DisplayName("replaceTEST")
    void test2(){
        List<String> msg = app.readFromFile("src/main/java/ex45/exercise45_input.txt");
        System.out.print(app.replaceText(msg, "utilize", "use"));
    }
    @Test
    @DisplayName("replaceTEST2")
    void test22(){
        List<String> msg = app.readFromFile("src/main/java/ex45/exercise45_input.txt");
        System.out.print(app.replaceText(msg, "She", "They"));
    }

    @Test
    @DisplayName("adding file")
    void test3(){
        List<String> msg = app.readFromFile("src/main/java/ex45/exercise45_input.txt");
        app.writeToFile("src/test/java/ex45/outputTest3.txt", msg);
    }
    @Test
    @DisplayName("adding file2")
    void test32(){
        List<String> msg = app.readFromFile("src/main/java/ex45/exercise45_input.txt");
        test22();
        app.writeToFile("src/test/java/ex45/outputTest32.txt", msg);
    }

}