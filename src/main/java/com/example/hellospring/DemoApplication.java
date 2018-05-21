package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements EnvironmentAware {

	private String appEnv = "staging";

	@RequestMapping("/")
	public String home() {
		return "Hello Spring World: " + appEnv;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void setEnvironment(Environment environment) {
		appEnv = environment.getProperty("APP_ENV");
	}
}
