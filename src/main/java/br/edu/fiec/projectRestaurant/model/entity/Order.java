package br.edu.fiec.projectRestaurant.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tableNumber")
    private Integer resTable;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "customer")
    private String customerName;
}
