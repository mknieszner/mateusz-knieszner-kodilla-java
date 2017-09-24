package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.isEqualCollection;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
  @Autowired
  CompanyDao companyDao;
  @Autowired
  EmployeeDao employeeDao;

  @Test
  public void testSaveManyToMany() {
    //Given
    final Set<Company> companyList = getPreparedCompanies();

    //When
    companyDao.save(companyList);

    //Then
    isEqualCollection(companyList, (Collection) companyDao.findAll());

    //CleanUp
    try {
      companyDao.delete(companyList);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testNamedQueries() {
    //Given
    final Set<Company> companyList = getPreparedCompanies();
    companyDao.save(companyList);

    //When
    final Set<Employee> resultEmployeeList = employeeDao.retrieveEmployeesByLastName("Smith");

    //Then
    assertEquals(1, resultEmployeeList.size());
    assertThat(resultEmployeeList)
        .extracting("lastname")
        .containsExactly("Smith");

    //CleanUp
    try {
      companyDao.delete(companyList);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testNamedNativeQueries() {
    //Given
    final Set<Company> companyList = getPreparedCompanies();
    companyDao.save(companyList);

    //When
    final Set<Company> resultCompanyList = companyDao.retrieveCompaniesByNameStartsWith("Sof");

    //Then
    assertEquals(1, resultCompanyList.size());
    assertEquals(1,
        resultCompanyList
            .stream()
            .map(Company::getName)
            .filter(name -> name.startsWith("Sof"))
            .count());

    //CleanUp
    try {
      companyDao.delete(companyList);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private Set<Company> getPreparedCompanies() {
    final Employee johnSmith = new Employee("John", "Smith");
    final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
    final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    final Company softwareMachine = new Company("Software Machine");
    final Company dataMaesters = new Company("Data Maesters");
    final Company greyMatter = new Company("Grey Matter");


    softwareMachine.addEmployee(johnSmith);
    dataMaesters.addEmployee(stephanieClarckson);
    dataMaesters.addEmployee(lindaKovalsky);

    johnSmith.addCompany(greyMatter);
    lindaKovalsky.addCompany(greyMatter);

    final Set<Company> companyList = new HashSet<>();
    companyList.add(softwareMachine);
    companyList.add(dataMaesters);
    companyList.add(greyMatter);

    return Collections.unmodifiableSet(companyList);
  }
}