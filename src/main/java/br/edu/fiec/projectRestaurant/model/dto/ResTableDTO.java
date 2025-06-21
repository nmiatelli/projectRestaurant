package br.edu.fiec.projectRestaurant.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResTableDTO {

    private Integer id_table;
    private Integer number_table;
    private String status;

}
