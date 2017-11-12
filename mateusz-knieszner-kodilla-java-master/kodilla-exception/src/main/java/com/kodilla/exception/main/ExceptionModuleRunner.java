package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

/**
 *
 */
public class ExceptionModuleRunner {

  public static void main(final String[] args) {

    final FileReader fileReader = new FileReader();
    try {
      fileReader.readFile();
    } catch (FileReaderException e) {
      System.out.println("!!!" + e);
    }
  }
}
