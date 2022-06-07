package com.example.demo;

import com.amazonaws.services.sns.AmazonSNS;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    NotificationMessagingTemplate notificationMessagingTemplate;

    public DemoApplication(AmazonSNS amazonSNS) {
        this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSNS);
    }

    public void sendMessage(){
        notificationMessagingTemplate.sendNotification("olt-june-sns","hey","TEST");
    }
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendMessage();
    }
}
