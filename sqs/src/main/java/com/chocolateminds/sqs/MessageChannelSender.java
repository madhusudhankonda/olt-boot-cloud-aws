package com.chocolateminds.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageChannelSender implements CommandLineRunner {
    private String QUEUE_ARN = "https://sqs.eu-west-2.amazonaws.com/304593876351/cloud-queue";

    private AmazonSQSAsync amazonSQSAsync;

    @Autowired
    public MessageChannelSender(AmazonSQSAsync amazonSQSAsync){
        this.amazonSQSAsync = amazonSQSAsync;
    }

    private void sendMessage(){
        MessageChannel messageChannel = new QueueMessageChannel(amazonSQSAsync, QUEUE_ARN);

        Message message = MessageBuilder.withPayload("Hello")
                            .build();

        System.out.println("Message sent: "+messageChannel.send(message));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending the message using non-message-template");
        sendMessage();
    }
}
