package com.ibm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ibm.BindingC.Order;
import com.ibm.Constants.AppConstant;

@Service
public class OderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkatemplate;

	public String addMsg(Order order) {

		kafkatemplate.send(AppConstant.Topic, order);

		return "oder message published to kafkaTopic";

	}

}
