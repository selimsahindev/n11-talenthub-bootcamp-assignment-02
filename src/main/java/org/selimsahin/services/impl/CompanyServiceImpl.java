package org.selimsahin.services.impl;

import org.selimsahin.dao.CompanyRepository;
import org.selimsahin.entity.Company;
import org.selimsahin.services.CompanyService;

import java.util.List;

/**
 * @author selimsahindev
 */
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl() {
        this.companyRepository = CompanyRepository.getInstance();
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return companyRepository.delete(id);
    }

    @Override
    public boolean update(Company company) {
        return companyRepository.update(company);
    }
}
