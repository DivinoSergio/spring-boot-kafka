package br.com.mendes.kafka.consumer.listener;

import br.com.mendes.kafka.consumer.dto.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.io.IOException;
import java.util.Map;

public class MensagemDeserializer implements Deserializer<MensagemDTO> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public MensagemDTO deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, MensagemDTO.class);
        } catch (IOException e) {
            throw new DeserializationException(topic, data, false, e);
        }
    }

}

