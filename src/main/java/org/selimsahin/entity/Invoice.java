package org.selimsahin.entity;

/**
 *  @author selimsahindev
 */
public class Invoice {
    private Long id;
    private String name;
    private String description;
    private double amount;
    private Customer customer;

    public Invoice() {
        // no-arg constructor
    }

    public Invoice(Long id, String name, String description, double amount, Customer customer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }

    public String toStringWithoutCustomer() {
        return "Invoice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
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
        if (!id.equals(invoice.id)) {
            return false;
        }
        if (!name.equals(invoice.name)) {
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
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + customer.hashCode();
        return result;
    }
}
