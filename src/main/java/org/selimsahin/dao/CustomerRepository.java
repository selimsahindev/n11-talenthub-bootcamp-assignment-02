package org.selimsahin.dao;

import org.selimsahin.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author selimsahindev
 */
public class CustomerRepository {

    private static CustomerRepository instance;
    private final Map<Long, Customer> customers;
    private Long nextId = 1L;

    // Made private to prevent anyone creating a new instance.
    private CustomerRepository() {
        customers = new HashMap<>();

        populateInitialData();
    }

    private void populateInitialData() {
        // Populate the repository with some initial data.
        save(new Customer("Selim", "Sahin", "selim.sahin@example.com"));
        save(new Customer("Alice", "Smith", "alice.smith@example.com"));
        save(new Customer("Michael", "Johnson", "michael.johnson@example.com"));
        save(new Customer("Emily", "Brown", "emily.brown@example.com"));
        save(new Customer("David", "Taylor", "david.taylor@example.com"));
    }

    // Made synchronized to prevent multiple threads from creating multiple instances.
    public static synchronized CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public Customer save(Customer customer) {
        long id = nextId++;
        customer.setId(id);

        customers.put(id, customer);
        return customer;
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public Customer findById(Long id) {
        return customers.get(id);
    }

    public boolean delete(Long id) {
        return customers.remove(id) != null;
    }

    public boolean update(Customer customer) {
        return customers.replace(customer.getId(), customer) != null;
    }
}
