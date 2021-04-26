package com.example.htmlToPdf;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.log.LoggerFactory;

import io.woo.htmltopdf.HtmlToPdf;
import io.woo.htmltopdf.HtmlToPdfObject;

@SpringBootApplication
public class HtmlToPdfApplication implements CommandLineRunner {
	private static final com.itextpdf.text.log.Logger LOGGER = LoggerFactory.getLogger(HtmlToPdfApplication.class);
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HtmlToPdfApplication.class, args);
	  

		boolean success = HtmlToPdf.create().object(HtmlToPdfObject.forUrl("index.html")).convert("D:\\PDFCONVERTer\\htmlToPdf\\html2pdf.pdf");
		System.out.println("PDF Created!");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
     // LOGGER.error("error occured");
	}

}
