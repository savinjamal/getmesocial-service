package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public boolean upload(MultipartFile file) {

        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIAUQ5GS36I62UID6OV", "EhExmhpGa+2YiaoVdakpxoPFVpRoMfVQcWj5EWDm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).withRegion(Regions.US_EAST_2).build();
        try {

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            s3.putObject("backend-spring2020", file.getOriginalFilename(), file.getInputStream(), objectMetadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public S3Object getFile(String key){

        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIAUQ5GS36I62UID6OV", "EhExmhpGa+2YiaoVdakpxoPFVpRoMfVQcWj5EWDm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).withRegion(Regions.US_EAST_2).build();
        return s3.getObject("backend-spring2020", key);

    }

    public void deleteFile(String key){

        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIAUQ5GS36I62UID6OV", "EhExmhpGa+2YiaoVdakpxoPFVpRoMfVQcWj5EWDm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).withRegion(Regions.US_EAST_2).build();
        s3.deleteObject("backend-spring2020", key);

    }
}
