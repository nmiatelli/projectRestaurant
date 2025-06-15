package br.edu.fiec.projectRestaurant.controller;

import br.edu.fiec.projectRestaurant.model.dto.CustomerDTO;
import br.edu.fiec.projectRestaurant.model.entity.Customer;
import br.edu.fiec.projectRestaurant.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "customer")
public class CustomerController {

    private final CustomerService customerService;

    //Cria um cliente
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="create",consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody CustomerDTO customerDTO){
        customerService.create(customerDTO);
    }

    //Busca os cliente pelo ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="id", produces = APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@RequestParam Integer id){
        return customerService.getCustomerById(id);

    }

    //Retorna a lista de todos os clientes
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="list",produces = APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //Busca cliente por numero de telefone
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="phoneNumber", produces = APPLICATION_JSON_VALUE )
    public Customer getCustomerByPhoneNumber(@RequestParam String phoneNumber){
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    //Atualiza/Edita cliente
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="update", consumes = APPLICATION_JSON_VALUE  )
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    //Deletar o cadastro
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteCustomer(Integer id){
        customerService.deleteCustomer(id);
    }





}
