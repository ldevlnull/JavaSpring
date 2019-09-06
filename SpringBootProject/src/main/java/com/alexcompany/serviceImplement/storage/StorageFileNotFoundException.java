package com.alexcompany.serviceImplement.storage;

import java.net.MalformedURLException;

public class StorageFileNotFoundException extends RuntimeException {
    public StorageFileNotFoundException(String message, MalformedURLException cause) {
        super(message, cause);
    }

    public StorageFileNotFoundException(String message) {
        super(message);
    }
}
