package com.zavada.domain;

import org.springframework.web.multipart.MultipartFile;

import com.zavada.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {
	private int id;
	private String email;
	private String password;	
	private String firstName;
	private String lastName;
	private int age;
	private MultipartFile file;
	private Role role;
	private String phoneNumber;
}
