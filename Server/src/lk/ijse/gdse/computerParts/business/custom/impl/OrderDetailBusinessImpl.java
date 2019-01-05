package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.OrderDetailBusiness;
import lk.ijse.gdse.computerParts.dto.OrderDetailsDTO;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.OrderDetailRepo;

public class OrderDetailBusinessImpl implements OrderDetailBusiness {

    OrderDetailRepo orderDetailRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.ORDERDETAIL);
    public OrderDetailBusinessImpl() {
    }

    @Override
    public boolean addOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return false;
    }
}
