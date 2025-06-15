package br.edu.fiec.projectRestaurant.controller;

import br.edu.fiec.projectRestaurant.model.dto.OrderDTO;
import br.edu.fiec.projectRestaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
