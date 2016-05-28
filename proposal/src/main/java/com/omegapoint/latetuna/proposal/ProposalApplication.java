package com.omegapoint.latetuna.proposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProposalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProposalApplication.class, args);
	}
}
