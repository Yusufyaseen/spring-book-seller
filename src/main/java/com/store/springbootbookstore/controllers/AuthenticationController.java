package com.store.springbootbookstore.controllers;

import com.store.springbootbookstore.model.User;
import com.store.springbootbookstore.service.IAuthenticationService;
import com.store.springbootbookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user) throws Exception {
        try {
            if (userService.findByUserName(user.getUsername()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) throws Exception {
        try {
            User signedUser = authenticationService.signInAndReturnJwt(user);
            return new ResponseEntity<>(signedUser, HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
