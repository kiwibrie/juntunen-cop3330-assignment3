package ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

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
