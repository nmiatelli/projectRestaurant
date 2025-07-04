package br.edu.fiec.projectRestaurant.repository;

import br.edu.fiec.projectRestaurant.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
