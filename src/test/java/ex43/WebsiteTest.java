package ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;
import java.io.IOException;

class WebsiteTest1 {
    Website web = new Website("TESTmysterymobile", "Velma Dinkley");

    @Test
    void generateSiteFolder() {
        try {
            web.generateSiteFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateIndexFile() {
        try {
            web.generateSiteFolder();
            web.generateIndexFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateJSFolder() {
        try {
            web.generateSiteFolder();
            web.generateJSFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateCSSFolder() {
        try {
            web.generateSiteFolder();
            web.generateCSSFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

class WebsiteTest2 {
    Website web = new Website("TESTTESTTEST", "author mcAuthorson");

    @Test
    void generateSiteFolder() {
        try {
            web.generateSiteFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateIndexFile() {
        try {
            web.generateSiteFolder();
            web.generateIndexFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateJSFolder() {
        try {
            web.generateSiteFolder();
            web.generateJSFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void generateCSSFolder() {
        try {
            web.generateSiteFolder();
            web.generateCSSFolder();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}