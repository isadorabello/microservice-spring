package io.github.isadorabello.microservice_spring.controller;

import io.github.isadorabello.microservice_spring.dto.UserDTO;
import io.github.isadorabello.microservice_spring.model.User;
import io.github.isadorabello.microservice_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser (@RequestBody @Valid UserDTO dto){
        var userModel = new User();
        BeanUtils.copyProperties(dto, userModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
