package br.edu.fiec.projectRestaurant.repository;


import br.edu.fiec.projectRestaurant.model.entity.ResTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResTableRepository extends JpaRepository<ResTable, Integer> {

    Optional<List<ResTable>> findTablesByStatus(String status);

}
