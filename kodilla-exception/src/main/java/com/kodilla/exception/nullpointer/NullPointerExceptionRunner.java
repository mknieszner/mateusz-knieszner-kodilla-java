package com.kodilla.exception.nullpointer;

/**
 *
 */
public class NullPointerExceptionRunner {
    public static void main(final String[] args) {
        final User user = null;
        final MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send,"
                    + "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}