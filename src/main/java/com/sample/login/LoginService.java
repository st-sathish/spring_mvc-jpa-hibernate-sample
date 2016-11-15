package com.sample.login;

import com.sample.model.User;

public interface LoginService {

	public User authenticateUser(String email, String password) throws Exception;

}
