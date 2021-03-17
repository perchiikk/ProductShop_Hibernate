package service.order;

import model.sql.Orders;

import java.util.List;

public interface OrderService {
    void dropOrderTable();

    void saveOrder(Orders orders);

    void removeOrderById(Integer id);

    List<Orders> getAllOrder();

    void cleanOrderTable();

    void removeWhere(Integer id);
}
