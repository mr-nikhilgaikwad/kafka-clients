package com.nikhil.uni.dataconsumer.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nikhil.uni.dataconsumer.configuration.ConsumerConfiguration;

@Service
public class ConsumerService {
	
	private ConsumerConfiguration consumerConfig;
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	public ConsumerService(ConsumerConfiguration consumerConfig) {
		this.consumerConfig = consumerConfig;
	}
	
	public void start() {
		var consumer = consumerConfig.getConsumer();
		consumer.subscribe(List.of(topicName));
		
		while(true) {
			var records = consumer.poll(Duration.ofMillis(100));
			for(var data: records) {
                System.out.printf("Offset: %d, Key: %s, Value: %s%n", data.offset(), data.key(), data.value());
			}
		}
	}
}
