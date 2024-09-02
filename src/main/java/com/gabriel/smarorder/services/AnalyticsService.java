package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.domain.models.Comanda;
import com.gabriel.smarorder.repositories.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyticsService {

    @Autowired
    private ComandaRepository comandaRepository;

    public Map<String, Long> getComandaAnalytics() {
        Map<String, Long> analytics = new HashMap<>();
        analytics.put("totalComandas", comandaRepository.count());
        analytics.put("comandasEmAndamento", comandaRepository.countByStatus(Status.ANDAMENTO));
        analytics.put("comandasEncerradas", comandaRepository.countByStatus(Status.ENCERRADO));
        analytics.put("comandasAbertas", comandaRepository.countByStatus(Status.ABERTO));
        return analytics;
    }

    // Implementação do método para obter dados mensais
    public Map<String, Object> getMonthlyData() {
        Map<String, Object> monthlyData = new HashMap<>();
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        List<Long> andamentoData = new ArrayList<>();
        List<Long> encerradasData = new ArrayList<>();
        List<Long> totalData = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            andamentoData.add(comandaRepository.countByStatusAndMonth(Status.ANDAMENTO, i));
            encerradasData.add(comandaRepository.countByStatusAndMonth(Status.ENCERRADO, i));
            totalData.add(comandaRepository.countByMonth(i));
        }

        monthlyData.put("labels", months);
        monthlyData.put("andamento", andamentoData);
        monthlyData.put("encerradas", encerradasData);
        monthlyData.put("total", totalData);

        return monthlyData;
    }

    // Implementação do método para obter dados de prioridade
    public List<Long> getPriorityData() {
        List<Long> priorityData = new ArrayList<>();
        priorityData.add(comandaRepository.countByPrioridade(Prioridade.BAIXA));
        priorityData.add(comandaRepository.countByPrioridade(Prioridade.MEDIA));
        priorityData.add(comandaRepository.countByPrioridade(Prioridade.ALTA));

        return priorityData;
    }
}

