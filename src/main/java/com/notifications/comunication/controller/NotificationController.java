package com.notifications.comunication.controller;

import com.notifications.comunication.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/message")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send/{email}")
    public ResponseEntity<String> sendNotificationTo(@PathVariable String email) throws Exception {
       emailService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body("succes");
    }
}
