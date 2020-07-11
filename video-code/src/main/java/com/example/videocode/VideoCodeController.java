package com.example.videocode;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import com.rabbitmq.client.Channel;
@Controller
public class VideoCodeController {
	int taskLimit = 2;
	@Bean
	public Queue VideoQueue() {
		return new Queue("VideoQueue", false);
	}

	@RabbitListener(queues = "VideoQueue")
	public void listen(Message message, Channel channel) throws IOException, InterruptedException {
		channel.basicQos(taskLimit, true);
		VideoCodeService VCS = new VideoCodeService(message, channel);
		VCS.start();
	}
}