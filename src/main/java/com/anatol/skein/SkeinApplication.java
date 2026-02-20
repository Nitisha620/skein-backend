package com.anatol.skein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkeinApplication {

	public static void main(String[] args) {
//		var orderService = new OrderService(new PaypalPaymentService());
//		orderService.placeOrder();
			SpringApplication.run(SkeinApplication.class, args);
	}

}
