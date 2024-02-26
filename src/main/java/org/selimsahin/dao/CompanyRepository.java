package org.selimsahin.dao;

import org.selimsahin.entity.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author selimsahindev
 */
public class CompanyRepository {

    private static CompanyRepository instance;
    private final HashMap<Long, Company> companies;
    private Long nextId = 1L;

    private CompanyRepository() {
        companies = new HashMap<>();

        populateInitialData();
    }

    private void populateInitialData() {
        // Populate the repository with some initial data.
        save(new Company("Apple", "Electronics"));
        save(new Company("Mercedes", "Automotive"));
        save(new Company("Oracle", "Software"));
        save(new Company("Microsoft", "Software"));
        save(new Company("Amazon", "E-commerce"));
        save(new Company("Facebook", "Social Media"));
    }

    public static synchronized CompanyRepository getInstance() {
        if (instance == null) {
            instance = new CompanyRepository();
        }
        return instance;
    }

    public Company save(Company company) {
        long id = nextId++;
        company.setId(id);

        companies.put(id, company);
        return company;
    }

    public List<Company> findAll() {
        return new ArrayList<>(companies.values());
    }

    public Company findById(Long id) {
        return companies.get(id);
    }

    public boolean delete(Long id) {
        return companies.remove(id) != null;
    }

    public boolean update(Company company) {
        return companies.replace(company.getId(), company) != null;
    }
}
