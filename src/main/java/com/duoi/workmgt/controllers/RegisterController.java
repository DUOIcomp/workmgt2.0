package com.duoi.workmgt.controllers;

import com.duoi.workmgt.Exception.UserInUseExc;
import com.duoi.workmgt.domain.User;
import com.duoi.workmgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        if (userService.findByUsername(user.getUsername()) != null) {
            throw new UserInUseExc();
            }

        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}