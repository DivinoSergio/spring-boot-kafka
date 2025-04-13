package br.com.mendes.kafka.producer.service;

import br.com.mendes.kafka.producer.dto.MensagemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MensagemService {

    Logger log = LoggerFactory.getLogger(MensagemService.class);

    @Value("${topic.app_consumer}")
    private String topicBoraPraticar;

    @Autowired
    private KafkaTemplate<String, MensagemDTO> kafkaTemplete;

    public void sendMessage(MensagemDTO message) {
        log.info("Mensagem -> {}", message);
        this.kafkaTemplete.send(topicBoraPraticar, message);
    }
}
