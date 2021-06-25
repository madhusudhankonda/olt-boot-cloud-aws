package com.chocolateminds.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SQSManager implements CommandLineRunner {

    private final String QUEUE_NAME = "my-sample04044";

    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SQSManager(AmazonSQSAsync amazonSQSAsync){
        queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void sendMessage(String message){
        System.out.println("Sending a message"+message);
        queueMessagingTemplate.convertAndSend(QUEUE_NAME, message);
    }

    /**
     * Receive a message using a listener
     * @param message
     */
    @SqsListener(QUEUE_NAME)
    public void receiveMessage(String message){
        System.out.println("Received message"+message);
    }

    /**
     * Receive a message by specifying a queuename on the template
     * @param queName
     */
    public void receive(String queName){
        Message<?> message = queueMessagingTemplate.receive(queName);
        System.out.println(">>"+message.getPayload());
    }
    @Override
    public void run(String... args) throws Exception {
//        sendMessage("Hello, SQS World!");
    //  receive(QUEUE_NAME);
    }
}
