package dao.product;

import model.sql.Products;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void dropProductTable() {
        try(Session session = SessionUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE products").executeUpdate();
            transaction.commit();
            System.out.println("Product table was dropped complete");
        }
        catch (Exception e){
            System.out.println("some exception in dropProductTable");
        }
    }

    @Override
    public void saveProduct(Products products) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(products);
            transaction.commit();
            System.out.println("Product was saved complete");
        }
        catch (Exception e){
            System.out.println("some exception in saveProduct");
        }
    }

    @Override
    public void removeProductById(Integer id) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.load(Products.class, id));
            transaction.commit();
            System.out.println("product was removed complete");
        }
        catch (Exception e){
            System.out.println("some exception in removeProductById");
        }
    }

    @Override
    public List<Products> getAllProduct() {
        List<Products> productsList;

        try(Session session = SessionUtil.getSessionFactory().openSession()){
            productsList = session.createQuery("FROM Products").list();
        }
        return productsList;
    }

    @Override
    public void cleanProductTable() {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM products").executeUpdate();
            transaction.commit();
            System.out.println("Product table was cleaned complete");
        }
        catch (Exception e){
            System.out.println("some exception in cleanProductTable");
        }
    }

    @Override
    public void updateProduct(Products products) {
        try (Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(products);
            transaction.commit();
        }
        catch (Exception e){
            System.out.println("some exception in updateProduct");
        }
    }

    @Override
    public Integer searchForIdProduct(String name) {
        int id = 0;
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("Select id From Products where name =:name")
                    .setParameter("name", name);
            id = (Integer) query.uniqueResult();
        } catch (Exception e){
            System.out.println("some exception in searchForIdProduct");
            e.printStackTrace();
        }
        return id;
    }

}
