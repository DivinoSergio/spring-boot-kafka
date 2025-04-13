package br.com.mendes.kafka.consumer.listener;

import br.com.mendes.kafka.consumer.dto.MensagemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerBoraPraticar {

    Logger log = LoggerFactory.getLogger(ConsumerBoraPraticar.class);

    @KafkaListener(topics = "${topic.app_consumer}", groupId = "group_id")
    public void consume(MensagemDTO message) throws IOException {
        log.info(String.format("### -> Consumindo mensagem -> %s", message));
    }

}
