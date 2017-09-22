package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    final List<Company> companyList = getPreparedCompanies();

    //When
    companyDao.save(companyList.get(0));
    companyDao.save(companyList.get(1));
    companyDao.save(companyList.get(2));

    //Then
    Assert.assertNotEquals(0, companyList.get(0).getId());
    Assert.assertNotEquals(0, companyList.get(1).getId());
    Assert.assertNotEquals(0, companyList.get(2).getId());

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
    final List<Company> companyList = getPreparedCompanies();
    companyDao.save(companyList.get(0));
    companyDao.save(companyList.get(1));
    companyDao.save(companyList.get(2));

    //When
    final List<Company> resultCompanyList = companyDao.retrieveCompaniesByNameStartsWith("Sof");
    final List<Employee> resultEmployeeList = employeeDao.retrieveEmployeesByLastName("Smith");

    //Then
    Assert.assertEquals(1, resultCompanyList.size());
    Assert.assertEquals(1, resultEmployeeList.size());

    //CleanUp
    try {
      companyDao.delete(companyList);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private List<Company> getPreparedCompanies() {
    final Employee johnSmith = new Employee("John", "Smith");
    final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
    final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    final Company softwareMachine = new Company("Software Machine");
    final Company dataMaesters = new Company("Data Maesters");
    final Company greyMatter = new Company("Grey Matter");

    //dodanie pracownika do firmy
    softwareMachine.addEmployee(johnSmith);
    dataMaesters.addEmployee(stephanieClarckson);
    dataMaesters.addEmployee(lindaKovalsky);

    //dodanie firmy do pracownika
    johnSmith.addCompany(greyMatter);
    lindaKovalsky.addCompany(greyMatter);

//    Dzięki dodaniu metod addEmployee i addCompany można dodawać tylko raz.
//    i zamiast poniższego kodu z kursu wystarczy tylko tyle ile jest powyżej
//    co więcej można dodawać pojedyńczo albo pracownika do firmy albo firmę do
//    pracownika efekt będzie identyczny.
//    Nie wiem czy to jest poprawne ale na pewno zabezpiecza przed podwójnym dodaniem
//    albo dodaniem tylko z jednej strony i specjalnie nie używałem metod z których
//    "korzysta" Hibernate żeby nie odpalało się coś w tle.

//    softwareMachine.getEmployees().add(johnSmith);
//    dataMaesters.getEmployees().add(stephanieClarckson);
//    dataMaesters.getEmployees().add(lindaKovalsky);
//    greyMatter.getEmployees().add(johnSmith);
//    greyMatter.getEmployees().add(lindaKovalsky);
//    johnSmith.getCompanies().add(softwareMachine);
//    johnSmith.getCompanies().add(greyMatter);
//    stephanieClarckson.getCompanies().add(dataMaesters);
//    lindaKovalsky.getCompanies().add(dataMaesters);
//    lindaKovalsky.getCompanies().add(greyMatter);

    final List<Company> companyList = new ArrayList<>();
    companyList.add(softwareMachine);
    companyList.add(dataMaesters);
    companyList.add(greyMatter);

    return Collections.unmodifiableList(companyList);
  }
}