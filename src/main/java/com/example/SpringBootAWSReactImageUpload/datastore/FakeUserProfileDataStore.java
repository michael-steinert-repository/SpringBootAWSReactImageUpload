package com.example.SpringBootAWSReactImageUpload.datastore;

import com.example.SpringBootAWSReactImageUpload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    //static initialization block
    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "michael", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "bruno", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
