package com.hellocat.restServerSpring.rest;

import com.hellocat.restServerSpring.domen.User;
import com.hellocat.restServerSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerForClient {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserWithName", method = RequestMethod.POST)
    public ResponseEntity<User> getUserWithName(@RequestBody String name) {
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
        boolean rezult = userService.saveUser(user);
        if (!rezult) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            //bad girl too
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
