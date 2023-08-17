package com.ibm.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.ibm.BindingC.Order;
import com.ibm.Constants.AppConstant;

@Configuration
public class KafkaConfig {

	@Bean
	public KafkaProducer<String, Order> producerFactory(){
		
		Map<String,Object>configs=new HashMap();
		
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.Host);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	KafkaTemplate<String, Order> kafkatemplate(){
		
	return new KafkaTemplate<>(producerFactory));
	}
}
