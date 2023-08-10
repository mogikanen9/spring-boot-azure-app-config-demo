package com.example.bootdemoazappconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class MessageProperties {
    private String message;
    
    private String mysecret1;

    
    public String getMysecret1() {
		return mysecret1;
	}

	public void setMysecret1(String mysecret1) {
		this.mysecret1 = mysecret1;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
