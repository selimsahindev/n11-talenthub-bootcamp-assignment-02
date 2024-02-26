package org.selimsahin.services;

import org.selimsahin.entity.Invoice;

import java.util.List;

/**
 * @author selimsahindev
 */
public interface InvoiceCalculatorService {

    public double calculateAverageAmount(List<Invoice> invoices);
}
