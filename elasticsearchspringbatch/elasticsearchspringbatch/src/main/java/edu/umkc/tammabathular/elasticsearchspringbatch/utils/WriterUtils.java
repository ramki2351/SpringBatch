package edu.umkc.tammabathular.elasticsearchspringbatch.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.Banner.Mode;
import edu.umkc.tammabathular.elasticsearchspringbatch.ElasticsearchspringbatchApplication;


public class WriterUtils implements CommandLineRunner{


	@Autowired
	public ReadAndLoadPropertyFiles readAndLoadPropertyFiles;

	@Bean
	public void printingValues() {

		System.out.println(readAndLoadPropertyFiles.getClusterName());
		System.out.println(readAndLoadPropertyFiles.getPort());
		System.out.println(readAndLoadPropertyFiles.getHost());
		System.out.println(readAndLoadPropertyFiles.getIndex());	
		System.out.println(readAndLoadPropertyFiles.getType());

	} 


	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(WriterUtils.class);
        app.setBannerMode(Mode.OFF);
        app.run(args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		WriterUtils writerUtils = new WriterUtils();

		writerUtils.printingValues();

	}



}
