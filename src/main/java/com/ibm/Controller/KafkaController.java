package com.ibm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.BindingC.Order;
import com.ibm.Service.OderService;

@RestController
public class KafkaController {
	@Autowired
	private OderService oderService;

	@PostMapping("/kafka")
	public String createOrder(@RequestBody Order order) {

		return oderService.addMsg(order);
	}
}
