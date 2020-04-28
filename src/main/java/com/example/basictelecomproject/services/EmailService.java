package com.example.basictelecomproject.services;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}
