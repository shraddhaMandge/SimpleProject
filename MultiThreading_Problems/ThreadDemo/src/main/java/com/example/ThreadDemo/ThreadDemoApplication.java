package com.example.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadDemoApplication {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new RunnableObject("myThread_" + i);
			executorService.execute(runnable);
		}	
		executorService.shutdown();
		
		SpringApplication.run(ThreadDemoApplication.class, args);
		
		while (!executorService.isTerminated())	{
			// wait
		}
		System.out.println("All threads completed successfully");
	}
	}
	


