package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/analytics")
public class AnalyticsResource {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public ResponseEntity<Map<String, Long>> getAnalytics() {
        Map<String, Long> analytics = analyticsService.getComandaAnalytics();
        return ResponseEntity.ok().body(analytics);
    }

    @GetMapping("/monthly-data")
    public ResponseEntity<Map<String, Object>> getMonthlyData() {
        Map<String, Object> monthlyData = analyticsService.getMonthlyData();
        return ResponseEntity.ok().body(monthlyData);
    }

    @GetMapping("/priority-data")
    public ResponseEntity<List<Long>> getPriorityData() {
        List<Long> priorityData = analyticsService.getPriorityData();
        return ResponseEntity.ok().body(priorityData);
    }
}
