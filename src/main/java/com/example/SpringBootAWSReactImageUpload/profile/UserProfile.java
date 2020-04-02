package com.example.SpringBootAWSReactImageUpload.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private final UUID userProfileId;
    private final String username;
    private String userProfileUmageLink; //s3-key-link not final because not real db

    public UserProfile(UUID userProfileId, String username, String userProfileUmageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileUmageLink = userProfileUmageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public Optional<String> getUserProfileUmageLink() {
        return Optional.ofNullable(userProfileUmageLink);
    }

    public void setUserProfileImageLink(String userProfileUmageLink) {
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
