package com.zavada.domain;

import org.hibernate.validator.constraints.NotEmpty;

import com.zavada.entity.enumeration.Role;
import com.zavada.validator.CheckPasswordsMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {

	// @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Typed email has not correct format")
	@NotEmpty private String email;
	@NotEmpty private String firstName;
	@NotEmpty private String lastName;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	private Role role;

}
