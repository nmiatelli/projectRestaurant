package br.edu.fiec.projectRestaurant.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DishName")
    private String dishName;

    @Column(name="Price")
    private Double price;

    //Cada item pertence a um pedido
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
