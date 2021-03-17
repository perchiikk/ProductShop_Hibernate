package dao.customer;

import model.sql.Customer;

import java.util.List;

public interface CustomerDao {
    void dropCustomerTable();

    void saveCustomer(Customer customer);

    void removeCustomerById(Integer id);

    List<Customer> getAllCustomers();

    void cleanCustomerTable();
}
