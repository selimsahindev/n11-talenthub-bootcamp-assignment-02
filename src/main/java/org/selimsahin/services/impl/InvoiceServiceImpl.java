package org.selimsahin.services.impl;

import org.selimsahin.dao.InvoiceRepository;
import org.selimsahin.entity.Invoice;
import org.selimsahin.services.InvoiceService;

import java.util.List;

/**
 * @author selimsahindev
 */
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl() {
        this.invoiceRepository = InvoiceRepository.getInstance();
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> findByCustomerId(Long customerId) {
        return invoiceRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Invoice> findByCustomerIds(List<Long> customerIds) {
        return invoiceRepository.findByCustomerIds(customerIds);
    }

    @Override
    public List<Invoice> findByAmountGTE(double amount) {
        return invoiceRepository.findByAmountGTE(amount);
    }

    @Override
    public List<Invoice> findByAmountLT(double amount) {
        return invoiceRepository.findByAmountLT(amount);
    }

    @Override
    public boolean delete(Long id) {
        return invoiceRepository.delete(id);
    }

    @Override
    public boolean update(Invoice invoice) {
        return false;
    }
}
