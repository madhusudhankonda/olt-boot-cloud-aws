package com.chocolateminds.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class FifoSQSManager implements CommandLineRunner {

    private String QUEUE_ARN = "https://sqs.eu-west-2.amazonaws.com/304593876351/cloud-queue.fifo";
    private AmazonSQSAsync amazonSQSAsync;

    @Autowired
    public FifoSQSManager(AmazonSQSAsync amazonSQSAsync){
        this.amazonSQSAsync = amazonSQSAsync;
    }

    private void sendToFifoQueue(String message, String messageGroupId, String dedupId){
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(QUEUE_ARN)
                .withMessageBody(message)
                .withMessageDeduplicationId(dedupId)
                .withMessageGroupId(messageGroupId);

        this.amazonSQSAsync.sendMessage(sendMessageRequest);
    }

    @Override
    public void run(String... args) throws Exception {
        sendToFifoQueue("Hello, Fifo","testing-123","123");
        System.out.println("Sent a message to FIFO successfully");
    }
}
