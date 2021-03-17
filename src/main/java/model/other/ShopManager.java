package model.other;

import model.sql.Products;
import service.help.ConsoleHelper;

import java.util.*;

public class ShopManager {
    private static Map<String, Integer> validProductMap = getAllNameFromStorage();
    private Map<String, Integer> mapOfOrder;

    private String nameCustomer;
    private int ageCustomer;
    private int budgetCustomer;

    public int getAgeCustomer() {
        return ageCustomer;
    }

    public int getBudgetCustomer() {
        return budgetCustomer;
    }

    public static Map<String, Integer> getValidProductMap() {
        return validProductMap;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    /**
     * Приветсвие с покупателем
     */
    public void sayHello() {
        ConsoleHelper.writeMessage("Добро пожаловать в наш магазин! Как вас зовут?");
        nameCustomer = ConsoleHelper.readText();
        ConsoleHelper.writeMessage("Сколько вам лет?");
        ageCustomer = ConsoleHelper.readInt();

        ConsoleHelper.writeMessage("Введите ваш бюджет");
        budgetCustomer = ConsoleHelper.readInt();

        ConsoleHelper.writeMessage("Отлично! Ваш профиль создан. Выберите позиции для покупки");
        for (Products products : Storage.getInstance().getStorageList()) {
            System.out.print(products.getName() + ", ");
        }
        System.out.println();
        System.out.println("====================");
    }

    /**
     * Покупатель делает набор продуктов
     *
     * @return продукт-количество
     */
    public Map<String, Integer> getOrder() {
        mapOfOrder = new HashMap<>();
        String order = "";
        int count = 0;
        boolean loadOrder = true;
        while (loadOrder) {
            order = getProductName();
            if (order.equals("Exit")) {
                loadOrder = false;
            }
            else {
                count = getCountOfProduct();
                if (validProductMap.get(order) < count) {
                    ConsoleHelper.writeMessage("Такого количества нет на складе");
                }
                mapOfOrder.put(order, count);
            }
        }
        return mapOfOrder;
    }

    /**
     * Чтение имение продукта с консоли
     */
    public String getProductName() {
        boolean loadOrder = true;
        String order = "";

        while (loadOrder) {
            ConsoleHelper.writeMessage("Введите название позиции или exit для выхода");
            order = ConsoleHelper.firstUpperCase(ConsoleHelper.readText());
            if(order.equals("Exit")){
                loadOrder = false;
            }
            else if (validProductMap.containsKey(order)) {
                return order;
            } else {
                ConsoleHelper.writeMessage("Вы ввели неверное название товара");
            }
        }
        return order = "Exit";
    }

    /**
     * Чтение количества с консоли
     */
    public int getCountOfProduct() {
        int count = 0;
        while (true) {
            ConsoleHelper.writeMessage("Введите количество");
            count = ConsoleHelper.readInt();
            if (count > 0) {
                return count;
            } else {
                ConsoleHelper.writeMessage("Введите число больше 0");
            }
        }
    }

    /**
     * Загрузка списка позиций со склада
     */
    private static Map<String, Integer> getAllNameFromStorage() {
        Map<String, Integer> validProductMap = new HashMap<>();
        for (Products products : Storage.getInstance().getStorageList()) {
            validProductMap.put(products.getName(), products.getCount());
        }
        return validProductMap;
    }
}
