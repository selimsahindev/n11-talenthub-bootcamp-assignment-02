package org.selimsahin.services.impl;

import org.selimsahin.entity.Invoice;
import org.selimsahin.services.InvoiceCalculatorService;
import org.selimsahin.services.InvoiceService;

import java.util.List;

/**
 * @author selimsahindev
 */
public class InvoiceCalculatorServiceImpl implements InvoiceCalculatorService {
    private final InvoiceService invoiceService;

    public InvoiceCalculatorServiceImpl(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public double calculateAverageAmount(List<Invoice> invoices) {
        double totalAmount = 0;
        for (Invoice invoice : invoices) {
            totalAmount += invoice.getAmount();
        }
        return totalAmount / invoices.size();
    }
}
