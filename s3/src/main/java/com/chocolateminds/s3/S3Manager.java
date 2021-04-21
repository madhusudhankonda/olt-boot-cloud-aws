package com.chocolateminds.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class S3Manager implements CommandLineRunner {

    private AmazonS3Client amazonS3Client;

    @Autowired
    private S3Manager(AmazonS3Client amazonS3Client){
        this.amazonS3Client = amazonS3Client;
    }

    public void createBucket(String bucketName){
        amazonS3Client.createBucket(bucketName);
    }
    @Override
    public void run(String... args) throws Exception {
        createBucket("bootcloudaws-8976");
    }
}
