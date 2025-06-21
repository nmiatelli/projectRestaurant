package br.edu.fiec.projectRestaurant.service;

import br.edu.fiec.projectRestaurant.model.dto.OrderItemDTO;
import br.edu.fiec.projectRestaurant.model.entity.OrderItem;
import br.edu.fiec.projectRestaurant.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemService {

    public final OrderItemRepository orderItemRepository;

    //RETORNA A LISTA DE ORDERITEMS
    public List<OrderItem> getAllOrderItems(){
        return (List<OrderItem>) orderItemRepository.findAll();
    }


    //CRIA UM ITEM
    public void createOrderItem(OrderItemDTO itemDTO){
        OrderItem item = new OrderItem();
        item.setDishName(itemDTO.getDishName());
        item.setPrice(itemDTO.getPrice());


        orderItemRepository.save(item);
    }


    //Busca por ID
    public OrderItem getOrderItemById(Integer id){
        return orderItemRepository.findById(id).orElse(null);
    }

    //Busca por prato
    public List<OrderItem> getItemByDish(String dishName){
        return  orderItemRepository.findOrderItemByDishName(dishName.toLowerCase()).orElse(null);
    }

    //ATUALIZAR
    public void updateOrderItem(OrderItem orderItem){

        Optional<OrderItem> itemUpdated = orderItemRepository.findById(orderItem.getId());

        if(itemUpdated.isPresent()){
            itemUpdated.get().setDishName(orderItem.getDishName());
            itemUpdated.get().setPrice(orderItem.getPrice());

            orderItemRepository.save(itemUpdated.get());
        }

    }


    //Deletar
    public void deleteOrderItem(Integer id){
        orderItemRepository.deleteById(id);
    }
}
