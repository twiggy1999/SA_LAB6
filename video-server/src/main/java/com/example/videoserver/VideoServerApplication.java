package com.example.videoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;
@SpringBootApplication
public class VideoServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VideoServerApplication.class, args);
		SpringApplication VideoServerApp = new SpringApplication(VideoServerApplication.class);
		VideoServerApp.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		VideoServerApp.run(args);
	}

}
