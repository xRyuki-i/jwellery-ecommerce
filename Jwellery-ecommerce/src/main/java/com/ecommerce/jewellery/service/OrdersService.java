package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.model.Orders;
import com.ecommerce.jewellery.dao.OrdersRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public Orders save(Orders orders){
        return ordersRepository.save(orders);
    }

    public Orders getById(long id){
        return ordersRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
    }

    public List<Orders> getAll(){
        return ordersRepository.findAll();
    }

    public Orders updateOrders(Long id, Orders updatedOrder){
        Orders existingOrders = ordersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingOrders.setTotalPrice(updatedOrder.getTotalPrice());

        return ordersRepository.save(existingOrders);
    }

    public String deleteById(long id){
        ordersRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        ordersRepository.deleteAll();

        return "All Admin deleted";
    }
}