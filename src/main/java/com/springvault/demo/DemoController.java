package com.springvault.demo;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springvault.demo.credentials.AwsCredentials;
import com.springvault.demo.credentials.AwsCredentialsService;
import com.springvault.demo.credentials.CredentialService;
import com.springvault.demo.credentials.Credentials;
import com.springvault.demo.credentials.TestBean;

@RestController
public class DemoController {
	
	@Autowired
	private CredentialService credentialService;

	@Autowired
	private AwsCredentialsService awsCredentialsService;

	@Autowired
	private TestBean testBean;

	@GetMapping("/demo/credentials")
	@ResponseStatus(code = HttpStatus.OK)
	public Credentials getCredentials() throws URISyntaxException {
		Credentials credentials = new Credentials("username", "password");
		credentialService.secureCredentials(credentials);
		return credentialService.accessCredentials();
	}

	@GetMapping("/demo/property")
	@ResponseStatus(code = HttpStatus.OK)
	public TestBean getPropertyTestBean() {
		return testBean;
	}

	@GetMapping("/demo/aws")
	@ResponseStatus(code = HttpStatus.OK)
	public AwsCredentials getAwsCredentials() {
		return awsCredentialsService.getCredentials();
	}

}
