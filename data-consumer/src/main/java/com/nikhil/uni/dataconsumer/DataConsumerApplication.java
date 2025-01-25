package com.nikhil.uni.dataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nikhil.uni.dataconsumer.service.ConsumerService;

@SpringBootApplication
public class DataConsumerApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(DataConsumerApplication.class, args);
		var consumer = ctx.getBean(ConsumerService.class);
		consumer.start();
	}

}
