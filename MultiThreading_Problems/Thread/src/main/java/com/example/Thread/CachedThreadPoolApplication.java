package com.example.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CachedThreadPoolApplication {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 30; i++) {
			service.execute(new RunnableObject("My Thread Number " + i));
		}
		SpringApplication.run(CachedThreadPoolApplication.class, args);
	}

}
