package com.cg.config;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cg.entity.User;
import com.cg.repository.UserRepository;

public class TrainingUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;

	public TrainingUserDetailsService(UserRepository userRepo) {
		// TODO Auto-generated constructor stub
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepo.findByUserName(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("userName not available"));
		return optionalUser.map(user -> new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), getAuthorities(user))).get();

	}

	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		return user.getRoles().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole()))
				.collect(Collectors.toList());
	}

	
	
}
