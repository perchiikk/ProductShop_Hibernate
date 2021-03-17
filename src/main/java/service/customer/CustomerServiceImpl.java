package service.customer;

import dao.customer.CustomerDao;
import dao.customer.CustomerDaoImpl;
import model.other.ShopManager;
import model.sql.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void dropCustomerTable() {
        customerDao.dropCustomerTable();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void removeCustomerById(Integer id) {
        customerDao.removeCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public void cleanCustomerTable() {
        customerDao.cleanCustomerTable();
    }

}
