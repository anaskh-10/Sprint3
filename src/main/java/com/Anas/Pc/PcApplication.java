package com.Anas.Pc;

import entities.Pc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.PcService;
import entities.Component;

import java.util.Date;

@SpringBootApplication
public class PcApplication implements CommandLineRunner {
	/*@Autowired
	PcService pcService;*/

	public static void main(String[] args) {
		SpringApplication.run(PcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* pcService.savePc(new Pc(null,"HP","Papillion1258",2600.0,new Date()));
		pcService.savePc(new Pc(null,"ASUS","TUF DUSH1056",3600.0,new Date()));
*/
	}
}
