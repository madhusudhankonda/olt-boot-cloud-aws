package com.chocolateminds.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;

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

    private void deleteBucket(String bucketName){
        amazonS3Client.deleteBucket(bucketName);
    }
    private void listBuckets(){
        amazonS3Client.listBuckets().stream().forEach(System.out::println);
    }

    private void downloadFile(String bucketName, String fileName){
        S3Object object = amazonS3Client.getObject(bucketName,fileName);
        System.out.println(object);
    }

    private void uploadFile(String bucketName, String fileName, File file) {
        amazonS3Client.putObject(bucketName,fileName,file);
    }


    @Override
    public void run(String... args) throws Exception {
        String bucketName = "bootcloudaws-8976";
        String fileName = "products.json";
//        createBucket("bootcloudaws-8976");
        File file = new File(fileName);
        uploadFile(bucketName,fileName, file);
        listBuckets();
        deleteBucket("temp-me/s3-resource-loader.iml");
    }
}
