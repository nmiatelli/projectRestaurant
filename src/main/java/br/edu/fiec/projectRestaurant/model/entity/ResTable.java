package br.edu.fiec.projectRestaurant.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resTable")
public class ResTable {

    @Id
    @Column(name="IdTable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_table;

    @Column(name = "TableNumber")
    private Integer number_table;

    @Column(name="TableStatus")
    private String status; //ocupada, livre



}
