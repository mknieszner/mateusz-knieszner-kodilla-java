package com.kodilla.patterns2.company;

import com.kodilla.patterns2.company.newhrsystem.CompanySalaryProcessor;
import com.kodilla.patterns2.company.newhrsystem.Employee;
import com.kodilla.patterns2.company.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class SalaryAdaptee implements SalaryProcessor {
  @Override
  public BigDecimal calculateSalaries(final List<Employee> employees) {
    final CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
    return theProcessor.calculateSalaries(employees);
  }
}
