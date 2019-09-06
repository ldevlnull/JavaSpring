package com.alexcompany.serviceImplement.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "C:\\Users\\User\\Desktop\\Tests\\springpagination\\src\\main\\resources\\static\\uploadedFiles";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
