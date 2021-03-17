import model.other.ProductCart;
import model.other.ShopManager;
import model.sql.Customer;
import service.assembly.Assembler;
import service.help.StorageHelper;

public class Main {

    public static void main(String[] args) {
        StorageHelper storageHelper = new StorageHelper();
        storageHelper.loadGrocery();

        ShopManager shopManager = new ShopManager();
        shopManager.sayHello();
        Customer customer = new Customer(shopManager.getNameCustomer(), shopManager.getAgeCustomer(), shopManager.getBudgetCustomer());
        ProductCart productCart = new ProductCart(shopManager, customer);
        productCart.loadOrder();
        productCart.loadResultOrder();
        productCart.buy();

        Assembler assembler = new Assembler(customer, productCart);
        assembler.saveOrder();
    }
}
