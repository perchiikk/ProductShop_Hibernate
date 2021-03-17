package dao.order;

import model.sql.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import java.util.List;

public class OrderDaoImpl implements OrderDao{
    @Override
    public void dropOrderTable() {
        try(Session session = SessionUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE orders").executeUpdate();
            transaction.commit();
            System.out.println("Order table was dropped complete");
        }
        catch (Exception e){
            System.out.println("some exception in dropOrderTable");
        }
    }

    @Override
    public void saveOrder(Orders orders) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(orders);
            transaction.commit();
            System.out.println("Orders was saved complete");
        }
        catch (Exception e){
            System.out.println("some exception in saveOrder");
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrderById(Integer id) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.load(Orders.class, id));
            transaction.commit();
            System.out.println("order was removed complete");
        }
        catch (Exception e){
            System.out.println("some exception in removeOrderById");
        }
    }

    @Override
    public List<Orders> getAllOrder() {
        List<Orders> ordersList;

        try(Session session = SessionUtil.getSessionFactory().openSession()){
            ordersList = session.createQuery("FROM Orders").list();
        }
        return ordersList;
    }

    @Override
    public void cleanOrderTable() {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM orders").executeUpdate();
            transaction.commit();
            System.out.println("Order table was cleaned complete");
        }
        catch (Exception e){
            System.out.println("some exception in cleanOrderTable");
        }
    }

    @Override
    public void removeWhere(Integer id) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            String hql = String.format("DELETE Order WHERE id = %s", id);
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(hql).executeUpdate();
            transaction.commit();
            System.out.printf("All orders where %s was removed complete", id);
        }
        catch (Exception e){
            System.out.println("some exception in removeWhere");
            e.printStackTrace();
        }
    }
}
