package br.edu.fiec.projectRestaurant.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data //executa getters e setters
@Entity //indica o tipo de classe
@NoArgsConstructor //cria metodo construtor vazio
@AllArgsConstructor  //cria metodo construtor completo
@Table(name = "clients") //cria a tabela no banco de dados
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Banco gera o id automaticamente, usando autoincremento.
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
