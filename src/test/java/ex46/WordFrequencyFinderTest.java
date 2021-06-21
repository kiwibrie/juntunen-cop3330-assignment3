package ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyFinderTest {
    WordFrequencyFinder app = new WordFrequencyFinder();
    List<Keyword> testlist = generateTestList();
    List<Keyword> sortedtestlist = generateTestListsorted();
    public List<Keyword> generateTestList(){
        List<Keyword> list = new ArrayList<>();
        list.add(new Keyword("scoob", 3));
        list.add(new Keyword("raggy", 5));
        list.add(new Keyword("glasses", 1));
        list.add(new Keyword("gang", 1));
        list.add(new Keyword("jeepers", 2));
        return list;
    }
    public List<Keyword> generateTestListsorted(){
        List<Keyword> list = new ArrayList<>();
        list.add(new Keyword("raggy", 5));
        list.add(new Keyword("scoob", 3));
        list.add(new Keyword("jeepers", 2));
        list.add(new Keyword("glasses", 1));
        list.add(new Keyword("gang", 1));
        return list;
    }

    @Test @DisplayName("print unsorted list")
    void printOutput() {
        app.printOutput(testlist);
    }
    @Test @DisplayName("print presorted list")
    void printOutput2() {
        app.printOutput(sortedtestlist);
    }

    @Test @DisplayName("print full text from file")
    void readFromFile() {
        System.out.print(app.readFromFile("src/main/java/ex46/exercise46_input.txt"));
    }

    @Test @DisplayName("print keylist")
    void generateKeyList() {
        app.printOutput(app.generateKeyList(app.readFromFile("src/main/java/ex46/exercise46_input.txt")));
    }

    @Test @DisplayName("first index")
    void getIndex() {
        System.out.print(app.getIndex(testlist, "scoob"));
        assertEquals(0, app.getIndex(testlist, "scoob"));
    }
    @Test @DisplayName("index later in list")
    void getIndex2() {
        System.out.print(app.getIndex(testlist, "gang"));
        assertEquals(3, app.getIndex(testlist, "gang"));
    }

    @Test @DisplayName("glasses in test list")
    void existsInList() {
        assertTrue(app.existsInList(testlist, "glasses"));
    }
    @Test @DisplayName("mystery in testlist")
    void existsInList2() {
        assertFalse(app.existsInList(testlist, "mystery"));
    }

    @Test @DisplayName("Sort Pass")
    void sortKeyList(){
        app.printOutput(sortedtestlist);
        System.out.print("\n");
        app.printOutput(app.sortKeyList(testlist));
        //should sort the same
    }
    @Test @DisplayName("Sort Fail")
    void sortKeyList2(){
        app.printOutput(testlist);
        System.out.print("\n");
        app.printOutput(app.sortKeyList(testlist));
        //should not be the same
    }

}