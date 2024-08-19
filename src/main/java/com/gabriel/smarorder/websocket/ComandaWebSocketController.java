package com.gabriel.smarorder.websocket;

import com.gabriel.smarorder.domain.dtos.ComandaDTO;
import com.gabriel.smarorder.domain.models.Comanda;
import com.gabriel.smarorder.services.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ComandaWebSocketController {

    @Autowired
    private ComandaService comandaService;

    @MessageMapping("/comanda")
    @SendTo("/topic/cozinha")
    public ComandaDTO processComanda(ComandaDTO comandaDTO) {
        Comanda novaComanda = comandaService.create(comandaDTO);
        return new ComandaDTO(novaComanda);
    }
}