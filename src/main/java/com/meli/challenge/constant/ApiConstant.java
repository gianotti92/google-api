package com.meli.challenge.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "api.constant")
public class ApiConstant {
	private String credentialFilePath;
	private String applicationName;
	
	public String getCredentialFilePath() {
		return credentialFilePath;
	}
	public void setCredentialFilePath(String credentialFilePath) {
		this.credentialFilePath = credentialFilePath;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}
