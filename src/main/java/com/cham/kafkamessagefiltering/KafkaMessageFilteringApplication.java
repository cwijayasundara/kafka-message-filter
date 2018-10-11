package com.cham.kafkamessagefiltering;

import com.cham.kafkamessagefiltering.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMessageFilteringApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaMessageFilteringApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		String firstMsg = "<note>\n" +
				"<to>Tom</to>\n" +
				"<from>Phil</from>\n" +
				"<heading>Reminder</heading>\n" +
				"<body>Don't forget me this weekend!</body>\n" +
				"</note>";
		kafkaProducer.send(firstMsg);
		String secondMsg = "<note>\n" +
				"<to>Chaminda</to>\n" +
				"<from>Boo</from>\n" +
				"<heading>Warning</heading>\n" +
				"<body>Don't mess with me!</body>\n" +
				"</note>";
		kafkaProducer.send(secondMsg);
	}
}
