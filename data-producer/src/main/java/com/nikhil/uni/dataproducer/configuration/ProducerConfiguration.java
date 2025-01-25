package com.nikhil.uni.dataproducer.configuration;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerConfiguration {
	@Value("${kafka.bootstrapservers}")
	private String bootstrapServer;
	
	@Value("${kafka.producer.acks}")
	private String acks;
	
	@Value("${kafka.producer.compression.type}")
	private String compressionType;
	
	@Value("${kafka.producer.retries}")
	private String retries;
	
	private Properties setProducerConfig() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ProducerConfig.ACKS_CONFIG, acks);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionType);
		props.put(ProducerConfig.RETRIES_CONFIG, retries); // Number of retry attempts
		
		return props;
	}
	
	public KafkaProducer<String, String> getProducer() {
		return new KafkaProducer<>(setProducerConfig());
		
	}
}
