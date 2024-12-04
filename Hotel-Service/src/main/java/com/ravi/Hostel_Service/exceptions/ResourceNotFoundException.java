package com.ravi.Hostel_Service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
    }
    public ResourceNotFoundException(){
        super("Resource not found");
    }
}
