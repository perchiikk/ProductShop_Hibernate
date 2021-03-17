package service.productservice;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import model.sql.Products;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void dropProductTable() {
        productDao.dropProductTable();
    }

    @Override
    public void saveProduct(Products products) {
        productDao.saveProduct(products);
    }

    @Override
    public void removeProductById(Integer id) {
        productDao.removeProductById(id);
    }

    @Override
    public List<Products> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public void cleanProductTable() {
        productDao.cleanProductTable();
    }

    @Override
    public void updateProduct(Products products) {
        productDao.updateProduct(products);
    }

    @Override
    public Integer searchForIdProduct(String name) {
        return productDao.searchForIdProduct(name);
    }

}
