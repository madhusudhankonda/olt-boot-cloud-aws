package com.chocolateminds.s3resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class S3Manager implements CommandLineRunner {

    @Autowired
    private ResourceLoader resourceLoader;

    private String BUCKET_NAME = "s3://bootcloudaws";

    private void getFile(String resourceName) throws IOException {
        Resource resource = this.resourceLoader.getResource(BUCKET_NAME+resourceName);
        System.out.println("Downloaded the file: "+resource.getFilename());
        File file = new File(resource.getFilename());

        Files.copy(resource.getInputStream(),file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private void uploadFile(File fileToBeUploaded, String resourceName) throws IOException {
        System.out.println("Resource path: "+BUCKET_NAME+resourceName);
        WritableResource writableResource = (WritableResource) this.resourceLoader.getResource(BUCKET_NAME+resourceName);

        try(OutputStream outputStream = writableResource.getOutputStream()){
            Files.copy(fileToBeUploaded.toPath(), outputStream);
//            outputStream.write("Hello, World".getBytes());
        }
        System.out.println("File uploaded, url is: "+BUCKET_NAME+resourceName);
    }

    @Override
    public void run(String... args) throws Exception {
        getFile("/products.json");
        uploadFile(new File("products.json"), "/new-produts.json");
    }
}
