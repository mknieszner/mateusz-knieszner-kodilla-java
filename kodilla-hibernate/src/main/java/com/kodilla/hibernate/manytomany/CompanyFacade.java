package com.kodilla.hibernate.manytomany;

import com.kodilla.hibernate.manytomany.dao.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Facade for repository service.
 */
@Service("companyFacade")
public class CompanyFacade {
  @Autowired
  private RepositoryService repositoryService;

  private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

  public Set<Company> retrieveCompaniesByPartOfName(final String partOfName) throws FinderException {
    LOGGER.info(String.format("Searching for companies with argument: %s", partOfName));
    boolean wasError = false;
    final Set<Company> companies;
    try {
      try {
        companies = checkNotNull(repositoryService.retrieveCompaniesByPartOfName(partOfName));
      } catch (NullPointerException ex) {
        LOGGER.error("NULL COMPANY SET RETURNED: " + ex);
        wasError = true;
        throw new FinderException(FinderException.ERROR_NULL_COMPANY_SET);
      }
      LOGGER.info(companies.isEmpty()
          ? "None company has fulfilled the condition."
          : String.format("%d compan%s has fulfilled the condition.", companies.size(), companies.size() == 1 ? "y" : "ies"));

      return companies;
    } finally {
      LOGGER.info(wasError ? "Search failed" : "Search succeed");
    }
  }

  public Set<Employee> retrieveEmployeesByPartOfName(final String partOfName) throws FinderException {
    LOGGER.info(String.format("Searching for employees with argument: %s", partOfName));
    boolean wasError = false;
    final Set<Employee> employees;
    try {
      try {
        employees = checkNotNull(repositoryService.retrieveEmployeesByPartOfName(partOfName));
      } catch (NullPointerException ex) {
        LOGGER.error("NULL EMPLOYEE SET RETURNED" + ex);
        wasError = true;
        throw new FinderException(FinderException.ERROR_NULL_EMPLOYEE_SET);
      }
      LOGGER.info(employees.isEmpty()
          ? "None employee has fulfilled the condition."
          : String.format("%d emplyee%s has fulfilled the condition.", employees.size(), employees.size() == 1 ? "" : "s"));

      return employees;
    } finally {
      LOGGER.info(wasError ? "Search failed" : "Search succeed");
    }
  }
}
