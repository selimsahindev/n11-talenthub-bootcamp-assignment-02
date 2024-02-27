# Patika.dev - Homework 02

This repository contains the second homework assignment for the Maven and Java fundamentals provided by **Patika.dev**. The application is a Maven project that demonstrates various functionalities related to managing customers and their invoices.

## Entities

### [**Customer**](src/main/java/org/selimsahin/entity/Customer.java) Entity:

| Field       | Description                       |
|-------------|-----------------------------------|
| `id`        | Unique identifier                 |
| `name`      | Name of the customer              |
| `surname`   | Surname of the customer           |
| `email`     | Email address of the customer     |
| `invoices`  | List of invoices associated       |


### [**Company**](src/main/java/org/selimsahin/entity/Company.java) Entity:

| Field      | Description               |
|------------|---------------------------|
| `id`       | Unique identifier         |
| `name`     | Name of the company       |
| `workArea` | Work area of the company  |


### [**Invoice**](src/main/java/org/selimsahin/entity/Invoice.java) Entity:

| Field         | Description                            |
|---------------|----------------------------------------|
| `id`          | Unique identifier                      |
| `description` | Description of the invoice             |
| `amount`      | Amount of the invoice                  |
| `date`        | Date of the invoice                    |
| `customer`    | Customer associated with the invoice   |
| `company`     | Company associated with the invoice    |



## Services
[**CompanyService**](src/main/java/org/selimsahin/services/CompanyService.java)
The CompanyService interface provides methods to manage company entities within the application. These methods include:

- `save(Company company)`: Saves a new company entity.
- `findAll()`: Retrieves a list of all companies stored in the system.
- `findById(Long id)`: Finds a company by its unique identifier.
- `delete(Long id)`: Deletes a company by its unique identifier.
- `update(Company company)`: Updates an existing company entity.

[**CustomerService**](src/main/java/org/selimsahin/services/CustomerService.java)
The CustomerService interface offers functionalities to manage customer entities in the application. It includes the following methods:

- `save(Customer customer)`: Saves a new customer entity.
- `findAll()`: Retrieves a list of all customers stored in the system.
- `findById(Long id)`: Finds a customer by its unique identifier.
- `searchByKeyword(String keyword)`: Searches for customers based on a keyword.
- `delete(Long id)`: Deletes a customer by its unique identifier.
- `update(Customer customer)`: Updates an existing customer entity.

[**InvoiceCalculatorService**](src/main/java/org/selimsahin/services/InvoiceCalculatorService.java)
The InvoiceCalculatorService interface provides a method to calculate the average amount of invoices. Its method includes:

- `calculateAverageAmount(List<Invoice> invoices)`: Calculates the average amount of invoices provided in the list.

[**InvoiceService**](src/main/java/org/selimsahin/services/InvoiceService.java)
The InvoiceService interface offers functionalities to manage invoice entities within the application. These methods include:

- `save(Invoice invoice)`: Saves a new invoice entity.
- `findAll()`: Retrieves a list of all invoices stored in the system.
- `findById(Long id)`: Finds an invoice by its unique identifier.
- `findByCustomerId(Long customerId)`: Retrieves invoices associated with a specific customer.
- `findByCustomerIds(List<Long> customerIds)`: Retrieves invoices associated with a list of customer identifiers.
- `findByAmountGTE(double amount)`: Retrieves invoices with an amount greater than or equal to the specified value.
- `findByAmountLT(double amount)`: Retrieves invoices with an amount less than the specified value.
- `delete(Long id)`: Deletes an invoice by its unique identifier.
- `update(Invoice invoice)`: Updates an existing invoice entity.

These service interfaces define the contract for managing company, customer, and invoice entities within the application, providing essential functionalities for CRUD (Create, Read, Update, Delete) operations and invoice amount calculations.

## Maven Commands

To compile and run the Maven project, you can use the following commands:

```bash
mvn clean install    # Cleans the project, compiles the source code, and packages it into a JAR file
java -jar target/homework-02-1.0-SNAPSHOT.jar    # Executes the Java application
```

<br />
<br />

**Author:** [**selimsahindev**](https://github.com/selimsahindev/)
