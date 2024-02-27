package org.selimsahin.services;

import org.selimsahin.entity.Invoice;

import java.util.List;

/**
 * @author selimsahindev
 */
public interface InvoiceService {

    Invoice save(Invoice invoice);

    List<Invoice> findAll();

    Invoice findById(Long id);

    List<Invoice> findByCustomerId(Long customerId);

    List<Invoice> findByCustomerIds(List<Long> customerIds);

    List<Invoice> findByAmountGTE(double amount);

    List<Invoice> findByAmountLT(double amount);

    boolean delete(Long id);

    boolean update(Invoice invoice);
}
