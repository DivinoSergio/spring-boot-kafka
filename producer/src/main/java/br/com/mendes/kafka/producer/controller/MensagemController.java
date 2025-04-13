package br.com.mendes.kafka.producer.controller;

import br.com.mendes.kafka.producer.dto.MensagemDTO;
import br.com.mendes.kafka.producer.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<MensagemDTO> enviarMensagem(@RequestBody MensagemDTO mensagem) {
        mensagemService.sendMessage(mensagem);
        return ResponseEntity.ok().body(mensagem);
    }
}
