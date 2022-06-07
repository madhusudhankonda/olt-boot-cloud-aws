package com.example.demo;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private AmazonS3Client amazonS3Client;
    
    @Autowired
    public DemoApplication(AmazonS3Client amazonS3Client){
        this.amazonS3Client = amazonS3Client;
    }
    
    public void createBucket(){
        amazonS3Client.createBucket("olt-june-temp-bucket2");
    }

    public void deleteBuckets(){
        amazonS3Client.deleteBucket("logstash-s3-olt");
    }

    public void listBuckets(){
        System.out.println(">"+amazonS3Client.listBuckets());
    }

    public void downloadFile(){
        S3Object s3Object = amazonS3Client.getObject("olt-june-temp-bucket2","very-berries-2.png");

        System.out.println(s3Object);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        createBucket();s3://olt-june-temp-bucket2
//        listBuckets();
//        downloadFile();
//        deleteBuckets();
    }
}
