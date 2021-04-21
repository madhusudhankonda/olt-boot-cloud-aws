package com.chocolateminds.sns;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsync;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class SNSMessagePublisher implements CommandLineRunner {

    private NotificationMessagingTemplate notificationMessageTemplate;

    private final String TOPIC_NAME = "arn:aws:sns:eu-west-2:304593876351:bootcloudaws-topic";

    @Autowired
    public SNSMessagePublisher(AmazonSNS amazonSNS){
        notificationMessageTemplate = new NotificationMessagingTemplate(amazonSNS);
    }

    private void sendMessage(String topicName, String message, String subject){
        System.out.println("Sending a message to "+topicName);
        notificationMessageTemplate.sendNotification(topicName, message, subject);
    }

    @Override
    public void run(String... args) throws Exception {
        String message = "Hello, Cloud AWS World!";
        String subject = "Notification from AWS";
        sendMessage(TOPIC_NAME, message, subject);
    }
}
