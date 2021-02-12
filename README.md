# spring-vault-demo

1. Checkout 'main' branch

2. Install Spring Vault : [HashiCorp Vault](https://www.vaultproject.io/downloads/)  

3. Run Vault (see example here: https://spring.io/guides/gs/vault-config/ )  
	a. From console with command:  
		vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"  
	b. Set environment variables:  
		export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"  
		export VAULT_ADDR="http://127.0.0.1:8200" 
		vault server --dev   

3. Build: 'mvn clean compile'

4. Run: 'mvn spring-boot:run'

5. Demo endpoint: GET localhost:8080/demo/credentials  
	- On each request it saves a username-password pair that is set in the code and then returns those credentials.   
	- Should return: "username=cica, password=kutya"  
	- The given endpoint always saves and returns this username/password, even if you modify the values manually in Vault. 		Therefore we can test endpoint by modfiying credentials manually in Vault and re-send the request.  


# About Vault
- local Vault: http://localhost:8200/
- You can add key-value pairs to Vault   
	a. in command line, eg.: vault kv put cubbyhole/demo username=demouser password=demopassword  
	b. Vault UI: http://localhost:8200/ui/vault/secrets.  




