package com.example.SpringBootAWSReactImageUpload.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private UUID userProfileId;
    private String username;
    private String userProfileUmageLink; //s3-key-link

    public UserProfile(UUID userProfileId, String username, String userProfileUmageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileUmageLink = userProfileUmageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserProfileUmageLink() {
        return Optional.ofNullable(userProfileUmageLink);
    }

    public void setUserProfileUmageLink(String userProfileUmageLink) {
        this.userProfileUmageLink = userProfileUmageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userProfileUmageLink, that.userProfileUmageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userProfileUmageLink);
    }
}