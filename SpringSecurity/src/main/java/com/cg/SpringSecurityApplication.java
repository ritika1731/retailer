package com.cg;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.entity.Role;
import com.cg.entity.User;
import com.cg.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();

		Role role = new Role("ADMIN");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		roles.add(new Role("USER"));
		User user = new User("Ritika", "abc", roles);
		userRepo.saveAndFlush(user);
		
		
		Set<Role> newRole = new HashSet<>();
		newRole.add(new Role("USER"));
		User user2 = new User("Prince", "xyz", newRole) ;
		userRepo.saveAndFlush(user2);
	}
}
