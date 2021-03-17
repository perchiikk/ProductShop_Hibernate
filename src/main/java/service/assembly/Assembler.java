package service.assembly;

import model.other.ProductCart;
import model.sql.Customer;
import model.sql.ListOfOrder;
import model.sql.Orders;
import model.sql.Products;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.listoforder.ListOfOrderService;
import service.listoforder.ListOfOrderServiceImpl;
import service.order.OrderService;
import service.order.OrderServiceImpl;
import service.productservice.ProductService;
import service.productservice.ProductServiceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Assembler {
    private Customer customer;
    private ProductCart productCart;
    private Orders order;
    private static final CustomerService customerService = new CustomerServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();

    public Assembler(Customer customer, ProductCart productCart) {
        this.customer = customer;
        this.productCart = productCart;
    }

    public void saveOrder() {
        order = new Orders(productCart.getSum(), new Date());
        order.setCustomer(customer);
        Map<Products, Integer> orderResult = productCart.getResultOrder();
        Set<ListOfOrder> ordersSet = new HashSet<>();
        for (Map.Entry<Products, Integer> entry : orderResult.entrySet()) {
            ListOfOrder listOfOrder = new ListOfOrder();
            listOfOrder.setProduct(entry.getKey());
            listOfOrder.setCount(entry.getValue());
            listOfOrder.setOrder(order);
            ordersSet.add(listOfOrder);
        }
        order.setListOfOrders(ordersSet);
        orderService.saveOrder(order);
    }

    public void deleteOrder() {
        orderService.removeOrderById(order.getId());
    }

    public void deleteCustomer() {
        deleteOrder();
        customerService.removeCustomerById(customer.getId());
    }


}
