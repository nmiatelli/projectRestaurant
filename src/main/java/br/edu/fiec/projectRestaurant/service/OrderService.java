package br.edu.fiec.projectRestaurant.service;

import br.edu.fiec.projectRestaurant.model.dto.OrderDTO;
import br.edu.fiec.projectRestaurant.model.entity.Order;
import br.edu.fiec.projectRestaurant.repository.OrderRepository;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //Buscar todos os pedidos
    public List<Order> getAllOrders(){
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

    public List<Order> getOrderbyTable(Integer resTable){
        return orderRepository.findByresTable(resTable);
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElseGet(null);
    }


    public void updateOrder(Order order){

        Optional<Order> orderUpdated = orderRepository.findById(order.getId());

        if(orderUpdated.isPresent()){
            orderUpdated.get().setCustomerName(order.getCustomerName());
            orderUpdated.get().setDate(order.getDate());
            orderUpdated.get().setResTable(order.getResTable());

            orderRepository.save(orderUpdated.get());
        }

    }








    //Metodo para deletar o pedido
    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }


}
