package com.nikhil.uni.dataproducer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.uni.dataproducer.common.Utility;
import com.nikhil.uni.dataproducer.configuration.ProducerConfiguration;
import com.nikhil.uni.dataproducer.model.Sensor;

@Service
public class ProducerService {
	
	private ProducerConfiguration producerConfig;
	
	@Value("${thread.sleep.ms}")
	private int sleepTime;
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	public ProducerService(ProducerConfiguration producerConfig) {
		this.producerConfig = producerConfig;
	}
	
	public void start() throws InterruptedException, JsonProcessingException {
		var producer = producerConfig.getProducer();
		int counter = 0;
		while(counter<1_000) {
			var data = new Sensor(Utility.getId(), Utility.getCurrentISOUtcDate(), Utility.getTemperature());
			var producerRecord = new ProducerRecord<String, String>(topicName, data.getId(), mapper.writeValueAsString(data));
			producer.send(producerRecord);
			counter++;
			Thread.sleep(sleepTime);
		}

	}
}
