package br.edu.fiec.projectRestaurant.controller;

import br.edu.fiec.projectRestaurant.model.dto.ResTableDTO;
import br.edu.fiec.projectRestaurant.model.entity.ResTable;
import br.edu.fiec.projectRestaurant.service.ResTableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "tables")
public class ResTableController {

    //INJETANDO O SERVICE NO CONTROLLER PARA CONSEGUIR USAR OS METODOS
    private final ResTableService resTableService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="create",consumes = APPLICATION_JSON_VALUE)
    public void createTable(@RequestBody ResTableDTO resTableDTO) {
        resTableService.createTable(resTableDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="list",produces = APPLICATION_JSON_VALUE)
    public List<ResTable> getAllTables(){
        return resTableService.getAllTables();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public ResTable getTableById(@RequestParam Integer id){
        return resTableService.getTableById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="status", produces = APPLICATION_JSON_VALUE)
    public List<ResTable> getTablesByStatus(@RequestParam String status){
        return resTableService.getTablesByStatus(status);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteTableById(Integer id){
        resTableService.deleteTableById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="update", consumes = APPLICATION_JSON_VALUE  )
    public void updateTable(@RequestBody ResTable resTable){
        resTableService.updateTable(resTable);
    }



}
