package br.edu.fiec.projectRestaurant.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    //Muitos pedidos tem um cliente
    @ManyToOne
    @JoinColumn(name = "customer_id") //cria a coluna foreign key
    private Customer customer;

    //Um pedido tem vários itens
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;
    //Aqui crio uma lista de objetos do tipo orderItem, pois em um pedido terei mais de um item.


}
