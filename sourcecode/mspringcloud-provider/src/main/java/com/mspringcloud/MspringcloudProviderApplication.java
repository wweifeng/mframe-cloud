package com.mspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MspringcloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspringcloudProviderApplication.class, args);
	}
}
