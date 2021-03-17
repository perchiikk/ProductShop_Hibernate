package dao.listoforder;

import model.sql.ListOfOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import java.util.List;

public class ListOfOrderDaoImpl implements ListOfOrderDao{

    @Override
    public void dropListOfOrderTable() {
        try(Session session = SessionUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE list_of_orders").executeUpdate();
            transaction.commit();
            System.out.println("Table list_of_orders was dropped complete");
        }
        catch (Exception e){
            System.out.println("some exception in dropListOfOrderTable");
        }
    }

    @Override
    public void saveListOfOrder(ListOfOrder list) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(list);
            transaction.commit();
            System.out.println("ListOfOrder was saved complete");
        } catch (Exception e){
            System.out.println("some exception in saveListOfOrder");
        }
    }

    @Override
    public void removeListOfOrderById(Integer id) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.load(ListOfOrder.class, id));
            transaction.commit();
            System.out.println("ListOfOrder was removed complete");
        }
        catch (Exception e){
            System.out.println("some exception in removeListOfOrderById");
        }
    }

    @Override
    public List<ListOfOrder> getAllListOfOrder() {
        List<ListOfOrder> list;

        try(Session session = SessionUtil.getSessionFactory().openSession()){
            list = session.createQuery("FROM ListOfOrder").list();
        }
        return list;
    }

    @Override
    public void cleanListOfOrderTable() {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM list_of_orders").executeUpdate();
            transaction.commit();
            System.out.println("List_of_orders table was cleaned complete");
        }
        catch (Exception e){
            System.out.println("some exception in cleanListOfOrderTable");
        }
    }
}
