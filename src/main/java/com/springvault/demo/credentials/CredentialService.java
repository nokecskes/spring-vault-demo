package com.springvault.demo.credentials;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class CredentialService {

	/*
	 * VaultTemplate configuration is provided in application.properties.
	 * 
	 * We can initialize our VaulTemplate also as:
	 * 
	 * VaultTemplate vaultTemplate = new VaultTemplate(new VaultEndpoint(), new
	 * TokenAuthentication("00000000-0000-0000-0000-000000000000"));
	 * 
	 * 
	 * There are multiple authentication methods available, e.g: token, appId, ASW
	 * EC2, Azure, Kubernetes etc.
	 * 
	 * See: EnvironmentVaultConfiguration.class
	 * 
	 * 
	 * Create new VaultEndpoint:
	 * 
	 * A) with default endpoint pointing to http://localhost:8200
	 * 
	 * VaultEndpoint endpoint = new VaultEndpoint();
	 * 
	 * 
	 * B) specify Vault host and port
	 * 
	 * VaultEndpoint endpoint = VaultEndpoint.create("host", port);
	 * 
	 * 
	 * C) create from Vault URL
	 * 
	 * VaultEndpoint endpoint = VaultEndpoint.from(new URI("vault uri"));
	 * 
	 */

	private static final String VAULT_DEMO_PATH_NAME = "cubbyhole/demo";

	@Autowired
	private VaultTemplate vaultTemplate;

	// We proved the Secret Engine's path and the key-value pair (secret) we want to
	// save.
	public void secureCredentials(Credentials credentials) {
		vaultTemplate.write(VAULT_DEMO_PATH_NAME, credentials);
	}

	// We read secrets by providing the Secret Engine's path.
	// Mapping to POJO works without any additional metadata.
	public Credentials accessCredentials() {
		VaultResponseSupport<Credentials> response = vaultTemplate.read(VAULT_DEMO_PATH_NAME, Credentials.class);
		return response.getData();
	}
}
