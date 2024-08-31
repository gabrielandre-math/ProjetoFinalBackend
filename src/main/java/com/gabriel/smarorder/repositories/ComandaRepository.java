package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.domain.models.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    Long countByStatus(Status status);

    Long countByPrioridade(Prioridade prioridade);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE MONTH(c.dataAbertura) = :month AND YEAR(c.dataAbertura) = :year")
    Long countByMonthAndYear(int month, int year);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE MONTH(c.dataAbertura) = :month")
    Long countByMonth(int month);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE c.status = :status AND MONTH(c.dataAbertura) = :month")
    Long countByStatusAndMonth(Status status, int month);
}
