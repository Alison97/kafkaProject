package com.pragma.demo.kafka.infraestructure.input.kafka.config.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.demo.kafka.application.dto.request.ClientRequestDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ClientKafkaConsumer {

    private final ObjectMapper objectMapper;

    public ClientKafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean(name = "config.kafka.client.consumerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, ClientRequestDTO> consumerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, ClientRequestDTO> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        ErrorHandlingDeserializer<ClientRequestDTO> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(new JsonDeserializer<>(ClientRequestDTO.class, objectMapper));
        DefaultKafkaConsumerFactory<String, ClientRequestDTO> consumerFactory = new DefaultKafkaConsumerFactory<>(
                this.getConfig(kafkaProperties),
                new StringDeserializer(),
                errorHandlingDeserializer
        );
        containerFactory.setConsumerFactory(consumerFactory);
        return containerFactory;
    }

    public static Map<String, Object> getConfig(KafkaProperties kafkaProperties) {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        return config;
    }

}
