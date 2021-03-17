package service.customer;

import model.sql.Customer;

import java.util.List;

public interface CustomerService {
    void dropCustomerTable();

    void saveCustomer(Customer customer);

    void removeCustomerById(Integer id);

    List<Customer> getAllCustomers();

    void cleanCustomerTable();
}
