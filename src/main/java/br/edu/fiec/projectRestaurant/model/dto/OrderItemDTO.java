package br.edu.fiec.projectRestaurant.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Integer id;
    private String dishName;
    private Double price;
}
