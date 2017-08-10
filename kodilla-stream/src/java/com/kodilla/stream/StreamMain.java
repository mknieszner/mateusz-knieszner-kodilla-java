package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        final PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.decorate("Give ", stringToDecorate ->
                System.out.print(stringToDecorate.toLowerCase()));
        poemBeautifier.decorate("me", stringToDecorate ->
                System.out.print(" " + stringToDecorate + " "));
        poemBeautifier.decorate(" a ", stringToDecorate ->
                System.out.print(stringToDecorate.trim()));
        poemBeautifier.decorate("challenge!", stringToDecorate ->
                System.out.println(" " + stringToDecorate.toUpperCase()));
    }
}