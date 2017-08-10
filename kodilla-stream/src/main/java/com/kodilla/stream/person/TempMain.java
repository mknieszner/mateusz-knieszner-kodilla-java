package com.kodilla.stream.person;

/**
 * temporary main class.
 */
public class TempMain {
        //public static void main(String[] args)
        {
                People.getList().stream()
                        .map(String::toUpperCase)
                        .filter(s -> s.length() > 11)
                        .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                        .filter(s -> s.substring(0, 1).equals("M"))
                        .forEach(System.out::println);
            }
        }