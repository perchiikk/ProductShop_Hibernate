package model.other;

import model.sql.Products;
import service.productservice.ProductService;
import service.productservice.ProductServiceImpl;

import java.util.List;

public class Storage {
    private ProductService productService = new ProductServiceImpl();

    private static Storage instance;
    private List<Products> storageList = productService.getAllProduct();

    private Storage() {
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Products> getStorageList() {
        return storageList;
    }

}
