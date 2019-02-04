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
	private String name;
	private String url;
	private String email;
	private String title;
	private String description;
	private String version;
	private String httpProtocol;
	private String protocols;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getHttpProtocol() {
		return httpProtocol;
	}
	public void setHttpProtocol(String httpProtocol) {
		this.httpProtocol = httpProtocol;
	}
	public String getProtocols() {
		return protocols;
	}
	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}
}
