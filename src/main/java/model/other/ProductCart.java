package model.other;

import model.sql.Customer;
import model.sql.Products;
import service.help.ConsoleHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCart {
    private Map<String, Integer> productCart = new HashMap<>();
    private ShopManager shopManager;

    private Map<Products, Integer> resultOrder = new HashMap<>();
    private Customer customer;

    public ProductCart(ShopManager shopManager, Customer customer) {
        this.shopManager = shopManager;
        this.customer = customer;
    }


    /**
     * Загрузить список позиций от ShopManager
     */
    public void loadOrder() {
        productCart = shopManager.getOrder();
    }

    public Map<Products, Integer> getResultOrder() {
        return resultOrder;
    }

    /**
     * Сопоставить выгруженный список с сущностями Products
     */
    public Map<Products, Integer> loadResultOrder() {

        for (Map.Entry<String, Integer> entry : productCart.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < Storage.getInstance().getStorageList().size(); i++) {
                Products someProduct = Storage.getInstance().getStorageList().get(i);
                if (someProduct.getName().equals(name)) {
                    resultOrder.put(someProduct, count);
                }
            }
        }
        ConsoleHelper.writeMessage("Товары успешно добавлены в корзину");
        ConsoleHelper.writeMessage(" ");
        ConsoleHelper.writeMessage("====================");
        return resultOrder;
    }

    /**
     * Процесс покупки
     */
    public void buy() {

        if (getAlco().size() > 0 && customer.getAge() < 18) {
            ConsoleHelper.writeMessage("Вам меньше 18, мы не можем продать алкоголь. Давайте уберем его из корзины");
            List<Products> alcoList = getAlco();
            for (Products products : alcoList) {
                removeAlcoFromOrder(products);
            }
        }
        if (customer.getBudget() - getSum() > 0) {
            ConsoleHelper.writeMessage("Ваша покупка на сумму " + getSum() + " выполнена успешно");
            customer.setBudget(customer.getBudget() - getSum());
        } else {
            ConsoleHelper.writeMessage("У вас недостаточно средств. Уберите что-нибудь из корзины");
        }
    }

    /**
     * Показать содержимое корзины
     */
    public void showResultOrder() {
        ConsoleHelper.writeMessage("Ваша корзина содержит:");
        for (Map.Entry<String, Integer> entry : productCart.entrySet()) {
            ConsoleHelper.writeMessage(entry.getKey() + " в количестве " + entry.getValue());
        }
        ConsoleHelper.writeMessage(" ");
        ConsoleHelper.writeMessage("====================");
    }

    /**
     * Удалить из корзины определенную позицию в опр количестве
     */
    public void removeFromOrder(String name, int count) {
        if (productCart.containsKey(name)) {
            int currentCount = productCart.get(name);
            if (currentCount > count) {
                productCart.put(name, currentCount - count);
                ConsoleHelper.writeMessage("Количетсво успешно изменено");
            } else if (currentCount == count) {
                productCart.remove(name);
                ConsoleHelper.writeMessage("Товар удален из корзины");
            } else {
                ConsoleHelper.writeMessage("Такого количества нет в корзине");
            }
        } else {
            ConsoleHelper.writeMessage("Такого товара нет в корзине");
        }
        ConsoleHelper.writeMessage(" ");
        ConsoleHelper.writeMessage("====================");
    }

    /**
     * Очистить корзину полностью
     */
    public void removeAll() {
        productCart.clear();
        System.out.println("Корзина пуста");
        ConsoleHelper.writeMessage(" ");
        ConsoleHelper.writeMessage("====================");
    }

    /**
     * Получить стоимость всех продуктов
     */
    public Integer getSum() {
        int sumAll = 0;
        Map<Products, Integer> resultSumm = resultOrder;
        for (Map.Entry<Products, Integer> entry : resultSumm.entrySet()) {
            double current = entry.getKey().getPrice() * entry.getValue();
            sumAll += current;
        }
        return sumAll;
    }


    public List<Products> getAlco() {
        List<Products> alcoProduct = new ArrayList<>();
        for (Map.Entry<Products, Integer> entry : resultOrder.entrySet()) {
            if (entry.getKey().isAlco()) {
                alcoProduct.add(entry.getKey());
            }
        }
        return alcoProduct;
    }

    public void removeAlcoFromOrder(Products products) {
        if (resultOrder.containsKey(products)) {
            resultOrder.remove(products);
            System.out.println("Алкоголь " + products.getName() + " успешно удален из корзины");
            ConsoleHelper.writeMessage(" ");
            ConsoleHelper.writeMessage("====================");
        }
    }

    public boolean getEmpty() {
        return productCart.isEmpty();
    }
}
