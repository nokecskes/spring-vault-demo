package com.springvault.demo.credentials;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class CredentialService {

	private static final String VAULT_DEMO_PATH_NAME = "cubbyhole/demo";

	@Autowired
	private VaultTemplate vaultTemplate;

	public void secureCredentials(Credentials credentials) {
		vaultTemplate.write(VAULT_DEMO_PATH_NAME, credentials);
	}

	public Credentials accessCredentials() {
		VaultResponseSupport<Credentials> response = vaultTemplate.read(VAULT_DEMO_PATH_NAME, Credentials.class);
		return response.getData();
	}
}
