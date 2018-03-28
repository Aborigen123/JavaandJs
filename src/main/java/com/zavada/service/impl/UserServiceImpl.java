package com.zavada.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zavada.entity.UserEntity;
import com.zavada.repository.UserRepository;
import com.zavada.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserEntity entity) {
		String methodName = "saveUser";
		log.debug("Start " + methodName);

		String password = entity.getPassword();
		log.debug("Entered password: " + password);
		entity.setPassword(passwordEncoder.encode(password));//хешування в Base64
		log.debug("Encoded password:" + entity.getPassword());
		userRepository.save(entity);

		log.debug("End " + methodName);
	}

	@Override
	public UserEntity findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void editUser(UserEntity entity) {
		userRepository.save(entity);
	}



}
