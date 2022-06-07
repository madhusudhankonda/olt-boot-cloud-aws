package com.example.demo;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public DemoApplication(AmazonSQSAsync amazonSQSAsync){
        queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void sendMessage(){
        queueMessagingTemplate.convertAndSend("olt-june","MyPayload");
    }

    public void receiveMessage(){
        String message  = queueMessagingTemplate.receiveAndConvert("olt-june",String.class);
        System.out.println("Payload 1: "+message);
    }

    @SqsListener("olt-june")
    public void recevieMessage2(String payload){
        System.out.println("Payload 2"+payload);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendMessage();
        receiveMessage();
    }
}
