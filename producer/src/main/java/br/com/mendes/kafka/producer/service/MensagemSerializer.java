package br.com.mendes.kafka.producer.service;

import br.com.mendes.kafka.producer.dto.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MensagemSerializer implements Serializer<MensagemDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public byte[] serialize(String topic, MensagemDTO data) {
        try {
            if (data == null || data.getOrigem().isBlank()) {
                System.out.println("Recebeu nulo na serialização");
                return null;
            }
            System.out.println("Serializando...");

            return objectMapper.writeValueAsBytes(data);

        } catch (Exception e) {
            throw new SerializationException("Erro ao serializar MessageDto para byte[]");
        }
    }

    @Override
    public void close() {
    }

}
