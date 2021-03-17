package service.listoforder;

import model.sql.ListOfOrder;

import java.util.List;

public interface ListOfOrderService {
    void dropListOfOrderTable();

    void saveListOfOrder(ListOfOrder list);

    void removeListOfOrderById(Integer id);

    List<ListOfOrder> getAllListOfOrder();

    void cleanListOfOrderTable();
}
