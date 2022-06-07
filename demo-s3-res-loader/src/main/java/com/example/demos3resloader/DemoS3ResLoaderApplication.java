package com.example.demos3resloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@SpringBootApplication
public class DemoS3ResLoaderApplication implements CommandLineRunner {

    @Autowired
    ResourceLoader resourceLoader;

    public void getFile(){
        Resource resource =
                resourceLoader.getResource("s3://olt-june-temp-bucket2/very-berries-2.png");

        System.out.println(resource.getFilename());
        File file = new File(resource.getFilename());

        try {
            Files.copy(resource.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        SpringApplication.run(DemoS3ResLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        getFile();
    }
}
