package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.domain.models.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    Long countByStatus(Status status);

    Long countByPrioridade(Prioridade prioridade);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE MONTH(c.dataAbertura) = :month AND YEAR(c.dataAbertura) = :year")
    Long countByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE MONTH(c.dataAbertura) = :month")
    Long countByMonth(@Param("month") int month);

    @Query("SELECT COUNT(c) FROM Comanda c WHERE c.status = :status AND MONTH(c.dataAbertura) = :month")
    Long countByStatusAndMonth(@Param("status") Status status, @Param("month") int month);

    @Query("SELECT c FROM Comanda c WHERE c.dataAtualizacao > :lastUpdateTime")
    List<Comanda> findByDataAtualizacaoAfter(@Param("lastUpdateTime") LocalDateTime lastUpdateTime);
}
