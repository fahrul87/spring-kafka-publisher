package com.fahrul.spring.kafka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "gita3";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template.send(topic, "Hi " + name + " Welcome to Istimiwir");
		return "Data published";
	}

	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(2532, "fahrul", new String[] { "Malang", "Jawa", "D 16" });
		template.send(topic, user);
		return "Json Data published";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}
}
