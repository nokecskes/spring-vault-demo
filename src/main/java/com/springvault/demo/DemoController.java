package com.springvault.demo;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springvault.demo.credentials.CredentialService;
import com.springvault.demo.credentials.Credentials;

@RestController
public class DemoController {
	
	@Autowired
	private CredentialService credentialService;

	@GetMapping("/demo/credentials")
	@ResponseStatus(code = HttpStatus.OK)
	public Credentials getCredentials() throws URISyntaxException {
		Credentials credentials = new Credentials("username", "password");
		credentialService.secureCredentials(credentials);
		return credentialService.accessCredentials();
	}
}
