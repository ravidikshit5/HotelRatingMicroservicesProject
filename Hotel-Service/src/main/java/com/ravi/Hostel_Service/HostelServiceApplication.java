package com.ravi.Hostel_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class HostelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelServiceApplication.class, args);
	}

}
