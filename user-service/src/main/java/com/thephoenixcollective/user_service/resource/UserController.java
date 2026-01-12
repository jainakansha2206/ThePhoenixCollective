package com.thephoenixcollective.user_service.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/user")
	public void getUser() {
		System.out.println("Hello User from your service");
	}

}
