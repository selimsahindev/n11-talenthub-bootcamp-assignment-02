package org.selimsahin.entity;

import java.util.List;

/*
 *  @author selimsahindev
 */
public class Customer {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<Invoice> invoices;

    public Customer() {
        // no-arg constructor
    }

    public Customer(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }

        Customer customer = (Customer) o;

        if (getId() != null ? !getId().equals(customer.getId()) : customer.getId() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(customer.getName()) : customer.getName() != null) {
            return false;
        }
        if (getSurname() != null ? !getSurname().equals(customer.getSurname()) : customer.getSurname() != null) {
            return false;
        }
        return getEmail() != null ? getEmail().equals(customer.getEmail()) : customer.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
