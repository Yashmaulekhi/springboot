package com.thymeleaf.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	@NotBlank(message="username cant be blank")
	@Size(min = 3 ,max= 12,message="userName must be 3 to 12 characters")
	private String userName;
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$",
	         message="Invalid email format")
	private String email;
	@AssertTrue
	private boolean agreed;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "LoginData [UserName=" + userName + ", email=" + email + "]";
	}
}
