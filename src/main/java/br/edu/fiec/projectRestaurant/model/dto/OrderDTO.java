package br.edu.fiec.projectRestaurant.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    private Integer resTable;
    private LocalDateTime date;
    private String customerName;
}

