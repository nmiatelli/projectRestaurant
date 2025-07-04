package br.edu.fiec.projectRestaurant.repository;


import br.edu.fiec.projectRestaurant.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

     List<Order> findByresTable(Integer resTable);
}
