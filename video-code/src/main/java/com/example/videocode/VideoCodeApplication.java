package com.example.videocode;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoCodeApplication {
	
	public static void main(String[] args) {

		SpringApplication VudeoCodeApp = new SpringApplication(VideoCodeApplication.class);
		VudeoCodeApp.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		VudeoCodeApp.run(args);

	}
}
