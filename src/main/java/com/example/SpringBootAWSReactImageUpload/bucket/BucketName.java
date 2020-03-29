package com.example.SpringBootAWSReactImageUpload.bucket;

public enum BucketName {

    PROFILE_IMAGE("michael-steinert-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
