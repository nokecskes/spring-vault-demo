package com.springvault.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

/*
 * EnvironmentVaultConfiguration allows configuration by using properties from existing property sources and Spring's Environment.
 * Here: application.properties
 * 
 * Can configure:
 * - Vault URI
 * - SSL configuration
 * - authentication method (default is TOKEN) and its configuration
 */
@Configuration
@Import(value = EnvironmentVaultConfiguration.class)
public class VaultConfiguration {
}

/*
 * We can configure Vault with extending AbstractVaultConfiguration:
 * 
 * It's a supporting configuration class that provides bean definitions Should
 * implement: vaultEndpoint() and clientAuthentication()
 *
 * Example:
 * 
 * @Configuration public class VaultConfig extends AbstractVaultConfiguration {
 *
 * @Override public ClientAuthentication clientAuthentication() { return new
 * TokenAuthentication("00000000-0000-0000-0000-000000000000"); }
 *
 * @Override public VaultEndpoint vaultEndpoint() { return
 * VaultEndpoint.create("host", 8020); } }
 * 
 */