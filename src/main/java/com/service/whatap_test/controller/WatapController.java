package com.service.whatap_test.controller;

import com.service.whatap_test.domain.UserDomain;
import com.service.whatap_test.service.WatapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watap")
public class WatapController {
    @Autowired
    private WatapService watapService;

    @GetMapping("/users")
    ResponseEntity<List<UserDomain>> getUser() {
        return ResponseEntity.status(HttpStatus.OK).body(watapService.findUserList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDomain> findUser(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(watapService.findUser(id));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(watapService.deleteUser(id));
    }

    @GetMapping("/user/find-name/{name}")
    public ResponseEntity<List<UserDomain>> findUserByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(watapService.findUserByName(name));
    }
}
