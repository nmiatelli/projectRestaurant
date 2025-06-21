package br.edu.fiec.projectRestaurant.repository;

import br.edu.fiec.projectRestaurant.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    Optional <List<OrderItem>> findOrderItemByDishName(String dishName);


}
