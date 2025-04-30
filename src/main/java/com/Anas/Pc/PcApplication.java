package com.Anas.Pc;

import com.Anas.Pc.entities.Pc;
import com.Anas.Pc.entities.Role;
import com.Anas.Pc.entities.User;
import com.Anas.Pc.service.UserService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PcApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(PcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Password Encoded BCRYPT :******************** ");
//		System.out.println(passwordEncoder.encode("123"));
	}
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}

