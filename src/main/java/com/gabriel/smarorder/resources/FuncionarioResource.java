package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.models.Garcom;
import com.gabriel.smarorder.repositories.GarcomRepository;
import com.gabriel.smarorder.services.GarcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/garcons")
public class GarcomResource {

    @Autowired
    private GarcomService garcomService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Garcom> findById(@PathVariable Integer id) {
        Garcom obj = garcomService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
