package service.help;

import model.sql.Products;
import service.productservice.ProductService;
import service.productservice.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class StorageHelper {
    private static final ProductService productService = new ProductServiceImpl();
    private static List<Products> grocery = new ArrayList<>();

    static {
        grocery.add(new Products(100, true, "Пиво", 50));
        grocery.add(new Products(123, false, "Сыр", 120));
        grocery.add(new Products(320, false, "Огурец", 140));
        grocery.add(new Products(70, false, "Сок", 100));
        grocery.add(new Products(80, false, "Оливки", 80));
        grocery.add(new Products(100, false, "Лук", 10));
        grocery.add(new Products(180, false, "Картошка", 90));
        grocery.add(new Products(130, false, "Томат", 80));
        grocery.add(new Products(90, true, "Вино", 350));
        grocery.add(new Products(100, true, "Водка", 50));
    }

    public void loadGrocery() {
        for (Products products : grocery) {
            productService.saveProduct(products);
        }
    }
}
