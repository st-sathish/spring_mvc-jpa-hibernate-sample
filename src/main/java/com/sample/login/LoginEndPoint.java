package com.sample.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sample.model.User;

@RestController
@RequestMapping("/api/")
public class LoginEndPoint {

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(LoginEndPoint.class);

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "v1/user/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> login(@RequestBody User user) throws Exception {
		try {
			user = loginService.authenticateUser(user.getEmail(), user.getPassword());
			System.out.println(user.getSecurityToken());
		} catch(Exception e) {
			throw e;
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
