# spring-vault-demo

1. Checkout 'main' branch

2. Install Spring Vault : [HashiCorp Vault](https://www.vaultproject.io/downloads/)  

3. Run Vault Dev server (see example here: https://spring.io/guides/gs/vault-config/ )  
	a. From console with command:  
		vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"  
	b. Set environment variables:  
		export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"  
		export VAULT_ADDR="http://127.0.0.1:8200" 
		vault server --dev   

4. Set the example secrets in Vault (see the "About Vault" section):  
4.1. Create secret/property and save a value to key: "property-key"  
4.2. Create secret/aws and save values with keys: "access_key_id", "secret_access_key"  

5. Build: 'mvn clean compile'

6. Run: 'mvn spring-boot:run'

7. Demo endpoints:   
7.1 GET localhost:8080/demo/credentials
	- On each request it saves a username-password pair (in cubbyhole/demo) that is set in the code and then returns those credentials.   
	- Should return: "username=username, password=password"  
	- The given endpoint always saves and returns this username/password, even if you modify the values manually in Vault. Therefore we can test endpoint by modfiying credentials manually in Vault and re-send the request.     
7.2 GET localhost:8080/demo/property   
	- This will return the "property-key" saved at 4.2.  
7.3 GET localhost:8080/demo/aws   
	- This will return the keys "access_key_id" and "secret_access_key" values saved at 4.3.  


# About Vault
- Local Vault UI: http://localhost:8200/
- You can add key-value pairs to Vault   
	a. in command line, eg.: vault kv put cubbyhole/demo username=demouser password=demopassword  
	b. Vault UI: http://localhost:8200/ui/vault/secrets.  




