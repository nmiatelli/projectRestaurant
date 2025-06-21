package br.edu.fiec.projectRestaurant.controller;

import br.edu.fiec.projectRestaurant.model.dto.OrderDTO;
import br.edu.fiec.projectRestaurant.model.entity.Order;
import br.edu.fiec.projectRestaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "order")
public class OrderController {

    private final OrderService orderService;

    //Cria um pedido
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="create",consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="id", produces = APPLICATION_JSON_VALUE)
    public Order getOrderById(@RequestParam Integer id){
        return orderService.getOrderById(id);

    }

    //Retorna a lista de todos os clientes
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="list",produces = APPLICATION_JSON_VALUE)
    public List<Order> getAllCustomers(){
        return orderService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="tableNumber", produces = APPLICATION_JSON_VALUE )
    public List<Order> getOrderbyTable(@RequestParam Integer resTable){
        return orderService.getOrderbyTable(resTable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="update", consumes = APPLICATION_JSON_VALUE  )
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }



    //Deletar o cadastro
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteOrder(Integer id){
        orderService.deleteOrder(id);
    }
}
