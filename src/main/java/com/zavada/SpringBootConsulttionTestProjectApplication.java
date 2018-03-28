package com.zavada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zavada.entity.Car;
import com.zavada.entity.CarEntity;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enumeration.Role;
import com.zavada.repository.CarEntityRepository;
import com.zavada.repository.UserRepository;

@SpringBootApplication
public class SpringBootConsulttionTestProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootConsulttionTestProjectApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsulttionTestProjectApplication.class, args);
		addAdmin(context);
		addCarEntity(context);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	
	static void addCarEntity(ConfigurableApplicationContext context) {
		CarEntityRepository carEntityRepository = context.getBean(CarEntityRepository.class);
		CarEntity carentity = carEntityRepository.findOne(1);
		
		if(carentity == null) {
			carEntityRepository.save(getCarEntitys());
		}
		
	}
	
	private static List<CarEntity> getCarEntitys(){
		List<CarEntity> carEntity = new ArrayList<>();
		
		carEntity.add(new CarEntity("Germany","BMW",5,12));
		carEntity.add(new CarEntity("Enland","Rand Rover",8,123));
		carEntity.add(new CarEntity("Ukraine","lada",55,2123));
		carEntity.add(new CarEntity("Poland","Audi",21,1283));
		carEntity.add(new CarEntity("France","Mazda",3,13));
		
		
		
		return carEntity;
	}
	
}
