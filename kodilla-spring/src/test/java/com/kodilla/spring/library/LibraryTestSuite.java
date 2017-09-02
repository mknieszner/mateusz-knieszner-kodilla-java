package com.kodilla.spring.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    ApplicationContext context;

    @Test
    public void testLoadFromDb() {
        //Given

        final Library library = context.getBean(Library.class);
        //When
        library.loadFromDb();
        //Then
        //do nothing
    }

    @Test
    public void testSaveToDb() {
        //Given
        final Library library = context.getBean(Library.class);
        //When
        library.saveToDb();
        //Then
        //do nothing
    }

    @Test
    public void testFirstContext() {
        //Given
        final ApplicationContext context =
            new AnnotationConfigApplicationContext(LibraryConfig.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
            .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    public void testSecondContext() {
        //Given
        final ApplicationContext context =
            new AnnotationConfigApplicationContext("com.kodilla.spring");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
            .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}