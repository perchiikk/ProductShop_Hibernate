package dao.customer;

import model.sql.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void dropCustomerTable() {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE customers").executeUpdate();
            transaction.commit();
            System.out.println("Table customers was dropped complete");
        } catch (Exception e) {
            System.out.println("some exception in dropCustomerTable");
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("Customer was saved complete");
        } catch (Exception e) {
            System.out.println("some exception in saveCustomer");
            e.printStackTrace();
        }
    }

    @Override
    public void removeCustomerById(Integer id) {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.load(Customer.class, id));
            transaction.commit();
            System.out.println("customer was removed complete");
        } catch (Exception e) {
            System.out.println("some exception in removeCustomerById");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList;

        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            customerList = session.createQuery("FROM Customer").list();
        }
        return customerList;
    }

    @Override
    public void cleanCustomerTable() {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM customers").executeUpdate();
            transaction.commit();
            System.out.println("Customer table was cleaned complete");
        } catch (Exception e) {
            System.out.println("some exception in cleanCustomerTable");
        }
    }
}
