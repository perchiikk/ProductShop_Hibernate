package dao.listoforder;

import model.sql.ListOfOrder;

import java.util.List;

public interface ListOfOrderDao {
    void dropListOfOrderTable();

    void saveListOfOrder(ListOfOrder list);

    void removeListOfOrderById(Integer id);

    List<ListOfOrder> getAllListOfOrder();

    void cleanListOfOrderTable();
}
