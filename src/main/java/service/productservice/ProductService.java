package service.productservice;

import model.sql.Products;

import java.util.List;

public interface ProductService {
    void dropProductTable();

    void saveProduct(Products products);

    void removeProductById(Integer id);

    List<Products> getAllProduct();

    void cleanProductTable();

    void updateProduct(Products products);

    Integer searchForIdProduct(String name);
}
