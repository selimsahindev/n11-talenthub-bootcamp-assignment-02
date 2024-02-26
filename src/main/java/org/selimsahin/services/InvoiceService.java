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

    boolean delete(Long id);
}
