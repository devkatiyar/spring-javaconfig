package com;

import org.springframework.batch.core.BatchStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchApplication {

	public static void main(String[] args) throws Exception {
		

		//SpringApplication.run(BatchApplication.class, args);
		System.exit(SpringApplication.exit(SpringApplication.run(BatchApplication.class, args)));

	}

}
