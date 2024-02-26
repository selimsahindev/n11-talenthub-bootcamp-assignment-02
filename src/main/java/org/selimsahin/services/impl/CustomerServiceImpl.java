package org.selimsahin.services.impl;

import org.selimsahin.dao.CustomerRepository;
import org.selimsahin.entity.Customer;
import org.selimsahin.services.CustomerService;

import java.util.List;

/**
 *  @author selimsahindev
 */
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = CustomerRepository.getInstance();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }
}
