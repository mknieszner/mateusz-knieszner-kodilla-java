package com.kodilla.patterns2.company.oldhrsystem;

/**
 *
 */
public class Workers {
  private String [][] workers = {
      {"6521468523", "John", "Smith"},
      {"6254869135", "Ivone", "Novak"},
      {"7521325896", "Jessie", "Pinkman"},
      {"7512341865", "Walter", "White"},
      {"7526841586", "Clara", "Lanson"}
  };

  private double [] salaries = {
      4500.00,
      3700.00,
      4350.00,
      9000.00,
      6200.00};


  public String getWorker(final int n) {
    if (n > salaries.length) {
      return "";
    }
    return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
  }

  public String[][] getWorkers() {
    return workers.clone();
  }

  public double[] getSalaries() {
    return salaries.clone();
  }
}

