package service.order;

import dao.order.OrderDao;
import dao.order.OrderDaoImpl;
import model.sql.ListOfOrder;
import model.sql.Orders;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.listoforder.ListOfOrderService;
import service.listoforder.ListOfOrderServiceImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    OrderDao orderDao = new OrderDaoImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void dropOrderTable() {
        orderDao.dropOrderTable();
    }

    @Override
    public void saveOrder(Orders orders) {
        customerService.saveCustomer(orders.getCustomer());

        orderDao.saveOrder(orders);
    }

    @Override
    public void removeOrderById(Integer id) {
        orderDao.removeOrderById(id);
    }

    @Override
    public List<Orders> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public void cleanOrderTable() {
        orderDao.cleanOrderTable();
    }

    @Override
    public void removeWhere(Integer id) {
        orderDao.removeWhere(id);
    }
}
