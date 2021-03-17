package service.listoforder;

import dao.listoforder.ListOfOrderDao;
import dao.listoforder.ListOfOrderDaoImpl;
import model.sql.ListOfOrder;

import java.util.List;

public class ListOfOrderServiceImpl implements ListOfOrderService{
    ListOfOrderDao listOfOrderDao = new ListOfOrderDaoImpl();

    @Override
    public void dropListOfOrderTable() {
        listOfOrderDao.dropListOfOrderTable();
    }

    @Override
    public void saveListOfOrder(ListOfOrder list) {
        listOfOrderDao.saveListOfOrder(list);
    }

    @Override
    public void removeListOfOrderById(Integer id) {
        listOfOrderDao.removeListOfOrderById(id);
    }

    @Override
    public List<ListOfOrder> getAllListOfOrder() {
        return listOfOrderDao.getAllListOfOrder();
    }

    @Override
    public void cleanListOfOrderTable() {
        listOfOrderDao.cleanListOfOrderTable();
    }
}
