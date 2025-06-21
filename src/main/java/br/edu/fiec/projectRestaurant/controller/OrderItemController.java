package br.edu.fiec.projectRestaurant.controller;


import br.edu.fiec.projectRestaurant.model.dto.OrderItemDTO;
import br.edu.fiec.projectRestaurant.model.entity.OrderItem;
import br.edu.fiec.projectRestaurant.model.entity.ResTable;
import br.edu.fiec.projectRestaurant.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(name = "item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    //Criar um item
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE )
    public void createOrderItem (@RequestBody OrderItemDTO orderItemDTO){
        orderItemService.createOrderItem(orderItemDTO);
    }

    //Get by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="id", produces = APPLICATION_JSON_VALUE)
    public OrderItem getOrderItemById(Integer id){
        return orderItemService.getOrderItemById(id);
    }

    //Get all
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="itemsList", produces = APPLICATION_JSON_VALUE)
    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }

    //Get By dish
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="dishName", produces = APPLICATION_JSON_VALUE)
    public List<OrderItem> getOrderByDish(@RequestParam String dishName){
        return orderItemService.getItemByDish(dishName);
    }

    //EDITAR
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="update", consumes = APPLICATION_JSON_VALUE  )
    public void updateOrderItem(@RequestBody OrderItem orderItem){
        orderItemService.updateOrderItem(orderItem);
    }


    //DELETE
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteOrderItem(Integer id){
        orderItemService.deleteOrderItem(id);
    }

}
