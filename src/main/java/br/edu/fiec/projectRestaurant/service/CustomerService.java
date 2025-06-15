package br.edu.fiec.projectRestaurant.service;

import br.edu.fiec.projectRestaurant.model.dto.CustomerDTO;
import br.edu.fiec.projectRestaurant.model.entity.Customer;
import br.edu.fiec.projectRestaurant.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;//imutabilidade do repository



    //Busca todos os clientes
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    //Metodo para criar o cliente
    public void create(CustomerDTO customerDTO){
        //CONVERTENDO DTO PARA ENTIDADE
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        customerRepository.save(customer);


    }

    //Metodo que busca por id
    public Customer getCustomerById(Integer id){

        return customerRepository.findById(id).orElse(null);

    }

    //Metodo que busca cliente por telefone
    public Customer getCustomerByPhoneNumber(String phoneNumber){

        return customerRepository.findByPhoneNumber(phoneNumber).orElse(null);

    }


    //Metodo para editar cliente
    public void updateCustomer(Customer customer){

        Optional<Customer> customerUpdated = customerRepository.findById(customer.getId());

        if(customerUpdated.isPresent()){
            customerUpdated.get().setName(customer.getName());
            customerUpdated.get().setPhoneNumber(customer.getPhoneNumber());
            customerRepository.save(customerUpdated.get());
        }

    }

    //Metodo para deletar o cadastro
    public void deleteCustomer(Integer id){
            customerRepository.deleteById(id);
    }





}
