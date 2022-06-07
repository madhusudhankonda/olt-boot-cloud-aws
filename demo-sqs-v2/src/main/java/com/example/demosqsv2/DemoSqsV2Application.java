package com.example.demosqsv2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;

@SpringBootApplication
public class DemoSqsV2Application implements CommandLineRunner {

    SqsClient sqsClient = SqsClient.builder().build();

    public void createQueue(){
        CreateQueueRequest createQueueRequest =
                CreateQueueRequest
                        .builder()
                        .queueName("temp-queue-v2").build();
        CreateQueueResponse createQueueResponse  = sqsClient.createQueue(createQueueRequest);
        System.out.println(createQueueResponse.toString());
    }
    
    public static void main(String[] args) {
        SpringApplication.run(DemoSqsV2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createQueue();
    }
}
