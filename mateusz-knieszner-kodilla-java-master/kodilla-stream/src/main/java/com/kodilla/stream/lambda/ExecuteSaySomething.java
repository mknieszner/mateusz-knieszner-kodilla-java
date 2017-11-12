package com.kodilla.stream.lambda;

/**
 * Contains printing process.
 */
public class ExecuteSaySomething implements Executor {

    @Override
    public void process() {
        System.out.println("This is an example text.");
    }
}