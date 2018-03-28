package com.zavada.service;

import com.zavada.entity.UserEntity;

public interface UserService {

	void saveUser(UserEntity entity);
	
	void editUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);

}
