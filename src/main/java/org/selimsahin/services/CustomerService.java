package org.selimsahin.services;

import org.selimsahin.entity.Customer;

import java.util.List;

/*
 *  @author selimsahindev
 */
public interface CustomerService {

    void save(Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);

    boolean delete(Long id);

    boolean update(Customer customer);

}
