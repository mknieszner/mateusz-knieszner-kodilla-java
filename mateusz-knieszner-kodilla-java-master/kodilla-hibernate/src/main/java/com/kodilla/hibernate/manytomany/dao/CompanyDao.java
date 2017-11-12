package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * Company database repository.
 */
@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

  Set<Company> retrieveCompaniesByNameStartsWith(@Param("PARTOFNAME") String partOfName);
}