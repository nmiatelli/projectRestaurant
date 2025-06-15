package br.edu.fiec.projectRestaurant.service;


import br.edu.fiec.projectRestaurant.model.dto.ResTableDTO;
import br.edu.fiec.projectRestaurant.model.entity.ResTable;
import br.edu.fiec.projectRestaurant.repository.ResTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResTableService {

    private final ResTableRepository resTableRepository;


    //CRIA UMA NOVA MESA - POST
    public void createTable(ResTableDTO resTableDTO){

        ResTable table = new ResTable();
        table.setNumber_table(resTableDTO.getNumber_table());
        table.setStatus(resTableDTO.getStatus());

        resTableRepository.save(table);
    }

    //LISTA TODAS AS MESAS - GET
    public List<ResTable> getAllTables(){
        return resTableRepository.findAll();
    }

    //PROCURA MESA PELO ID - GET
    public ResTable getTableById(Integer id){

        return resTableRepository.findById(id).orElse(null);
    }

    //LISTA AS MESAS POR STATUS - GET
    public List<ResTable> getTablesByStatus(String status){
        return resTableRepository.findTablesByStatus(status.toLowerCase()).orElse(null);
    }


    //DELETA UMA MESA - DELETE
    public void deleteTableById(Integer id){
        resTableRepository.deleteById(id);
    }

    public void updateTable(ResTable resTable){

        Optional<ResTable> tableUpdated = resTableRepository.findById(resTable.getId_table());

        if(tableUpdated.isPresent()){
            tableUpdated.get().setNumber_table(resTable.getNumber_table());
            tableUpdated.get().setStatus(resTable.getStatus());
            resTableRepository.save(tableUpdated.get());
        }

    }



}
