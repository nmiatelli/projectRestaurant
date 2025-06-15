package br.edu.fiec.projectRestaurant.service;

import br.edu.fiec.projectRestaurant.model.dto.OrderDTO;
import br.edu.fiec.projectRestaurant.model.entity.Order;
import br.edu.fiec.projectRestaurant.repository.OrderRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //Buscar todos os pedidos
    public List<Order> getAllOrder(){
        return (List<Order>) orderRepository.findAll();
    }

    //Postar o pedido
    public void createOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setDate(orderDTO.getDate());
        order.setResTable(orderDTO.getResTable());
        order.setCustomerName(orderDTO.getCustomerName());

        orderRepository.save(order);


    }


}
