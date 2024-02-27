package org.selimsahin.dao;

import org.selimsahin.entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author selimsahindev
 */
public class InvoiceRepository {

    private static InvoiceRepository instance;
    private final Map<Long, Invoice> invoices;
    private Long nextId = 1L;

    private InvoiceRepository() {
        invoices = new HashMap<>();

        populateInitialData();
    }

    // Singleton pattern
    public static synchronized InvoiceRepository getInstance() {
        if (instance == null) {
            instance = new InvoiceRepository();
        }
        return instance;
    }

    public Invoice save(Invoice invoice) {
        if (invoice.getId() == null) {
            invoice.setId(nextId++);
        }
        invoices.put(invoice.getId(), invoice);
        return invoice;
    }

    private void populateInitialData() {
        CustomerRepository customerRepo = CustomerRepository.getInstance();
        CompanyRepository companyRepo = CompanyRepository.getInstance();
        LocalDate time = LocalDate.now();

        save(new Invoice("Invoice 1", 100.0, time, customerRepo.findById(1L), companyRepo.findById(1L)));
        save(new Invoice("Invoice 2", 200.0, time, customerRepo.findById(2L), companyRepo.findById(2L)));
        save(new Invoice("Invoice 3", 300.0, time, customerRepo.findById(3L), companyRepo.findById(3L)));
        save(new Invoice("Invoice 4", 400.0, time, customerRepo.findById(4L), companyRepo.findById(4L)));
        save(new Invoice("Invoice 5", 500.0, time, customerRepo.findById(5L), companyRepo.findById(5L)));
    }

    public List<Invoice> findAll() {
        return new ArrayList<>(invoices.values());
    }

    public Invoice findById(Long id) {
        return invoices.get(id);
    }

    public List<Invoice> findByCustomerId(Long customerId) {
        List<Invoice> customerInvoices = new ArrayList<>();

        for (Invoice invoice : invoices.values()) {
            if (invoice.getCustomer().getId().equals(customerId)) {
                customerInvoices.add(invoice);
            }
        }

        return customerInvoices;
    }

    public List<Invoice> findByCustomerIds(List<Long> customerIds) {
        List<Invoice> customerInvoices = new ArrayList<>();

        for (Invoice invoice : invoices.values()) {
            if (customerIds.contains(invoice.getCustomer().getId())) {
                customerInvoices.add(invoice);
            }
        }

        return customerInvoices;
    }

    // Returns a list of invoices with an amount greater than or equal to the given amount.
    public List<Invoice> findByAmountGTE(double amount) {
        List<Invoice> customerInvoices = new ArrayList<>();

        for (Invoice invoice : invoices.values()) {
            if (invoice.getAmount() >= amount) {
                customerInvoices.add(invoice);
            }
        }

        return customerInvoices;
    }

    // Returns a list of invoices with an amount less than the given amount.
    public List<Invoice> findByAmountLT(double amount) {
        List<Invoice> customerInvoices = new ArrayList<>();

        for (Invoice invoice : invoices.values()) {
            if (invoice.getAmount() < amount) {
                customerInvoices.add(invoice);
            }
        }

        return customerInvoices;
    }

    public boolean delete(Long id) {
        return invoices.remove(id) != null;
    }

    public boolean update(Invoice invoice) {
        return invoices.replace(invoice.getId(), invoice) != null;
    }
}
