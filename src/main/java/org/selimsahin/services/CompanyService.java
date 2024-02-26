package org.selimsahin.services;

import org.selimsahin.entity.Company;

import java.util.List;

/**
 * @author selimsahindev
 */
public interface CompanyService {

    void save(Company company);

    List<Company> findAll();

    Company findById(Long id);

    boolean delete(Long id);

    boolean update(Company company);
}
