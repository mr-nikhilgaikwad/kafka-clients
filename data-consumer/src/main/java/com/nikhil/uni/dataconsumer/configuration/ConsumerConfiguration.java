package com.nikhil.uni.dataconsumer.configuration;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsumerConfiguration {
	
	@Value("${kafka.bootstrapservers}")
	private String bootstrapServer;
	
	@Value("${kafka.consumer.group}")
	private String consumerGroup;
	
	@Value("${kafka.consumer.offset.reset}")
	private String offsetReset;
	
	@Value("${kafka.consumer.max.poll.record}")
	private int maxPollRecords;
	
	@Value("${kafka.consumer.max.poll.interval}")
	private int maxPollInterval;
	
	
	private Properties setConfiguration() {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetReset); 
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, consumerGroup); 
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords); 
		props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollInterval); 
		
		return props;
	}
	
	public KafkaConsumer<String, String> getConsumer(){
		return new KafkaConsumer<>(setConfiguration());
	}
}
