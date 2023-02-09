package com.kyzen.authnauthz;

import com.kyzen.authnauthz.config.RsaKeyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfig.class)
public class AuthnAuthzApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthnAuthzApplication.class, args);
	}

}
