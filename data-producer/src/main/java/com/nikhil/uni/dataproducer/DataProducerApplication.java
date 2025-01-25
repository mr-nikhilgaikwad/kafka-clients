package com.nikhil.uni.dataproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nikhil.uni.dataproducer.service.ProducerService;

@SpringBootApplication
public class DataProducerApplication {

	public static void main(String[] args) throws JsonProcessingException, InterruptedException {
		var ctx = SpringApplication.run(DataProducerApplication.class, args);
		var producerService = ctx.getBean(ProducerService.class);
		producerService.start();
	}
}
