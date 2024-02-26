package org.selimsahin.entity;

import java.time.LocalDate;

/**
 * @author selimsahindev
 */
public class Invoice {
    private Long id;
    private String description;
    private double amount;
    private LocalDate date;
    private Customer customer;

    public Invoice() {
        // no-arg constructor
    }

    public Invoice(Long id, String description, double amount, Customer customer, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.customer = customer;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }

    public String toStringWithoutCustomer() {
        return "Invoice{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Invoice invoice = (Invoice) o;

        if (Double.compare(invoice.amount, amount) != 0) {
            return false;
        }
        if (!date.equals(invoice.date)) {
            return false;
        }
        if (!id.equals(invoice.id)) {
            return false;
        }
        if (!description.equals(invoice.description)) {
            return false;
        }
        return customer.equals(invoice.customer);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + customer.hashCode();
        return result;
    }
}
