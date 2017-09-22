package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents Company.
 */
@NamedQuery(
    name = "Company.retrieveCompaniesByNameStartsWith",
    query = "FROM Company WHERE SUBSTR(name, '1' , '3') = :PARTOFNAME"
)
@Entity
@Table(name = "COMPANIES")
public class Company {
  private int id;
  private String name;
  private List<Employee> employees = new ArrayList<>();

  public Company() {
  }

  public Company(final String name) {
    this.name = name;
  }

  //zobacz komentarz w CompanyDaoTestSuite w metodzie getPreparedCompanies.
  public void addEmployee(final Employee employee) {
    if (!employees.contains(employee)) {
      employees.add(employee);
    }
    if (!employee.getCompanies().contains(this)) {
      employee.addCompany(this);
    }
  }

  @ManyToMany(
      cascade = CascadeType.ALL,
      mappedBy = "companies"
  )
  public List<Employee> getEmployees() {
    return new ArrayList<>(employees);
  }

  private void setEmployees(final List<Employee> employees) {
    this.employees = employees;
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "COMPANY_ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "COMPANY_NAME")
  public String getName() {
    return name;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setName(final String name) {
    this.name = name;
  }
}