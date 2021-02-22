package com.springvault.demo.credentials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.annotation.VaultPropertySource;

@Service
@VaultPropertySource(value = "secret/aws", propertyNamePrefix = "jsa.aws.")
public class AwsCredentialsService {

	// With the propertyNamePrefix set we only store the key as 'access_key_id' in
	// secret/aws.
	@Value("${jsa.aws.access_key_id:access_key_id}")
	private String accessKey;

	@Value("${jsa.aws.secret_access_key:super_secret_key}")
	private String secretKey;

	// Mock AwsCredentials
	public AwsCredentials getCredentials() {
		return new AwsCredentials(accessKey, secretKey);
	}
}
