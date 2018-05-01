package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${spring.cloud.config.uri}")
    String url;
	
	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		System.out.println(url + "<--------------");
		System.out.println(message + "<--------------");

		return this.message;
	}
}
