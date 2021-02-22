package com.springvault.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.annotation.VaultPropertySource;

import com.springvault.demo.credentials.TestBean;

@Configuration
@VaultPropertySource("secret/property")
public class DemoAppConfig {

	@Autowired
	Environment env;

	@Bean
	public TestBean testBean() {
		String value = env.getProperty("property-key");
		TestBean testBean = new TestBean(value);
		return testBean;
	}

}
