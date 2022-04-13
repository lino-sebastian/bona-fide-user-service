package com.post.meridiem.contoller;

import com.post.meridiem.api.service.UserService;
import com.post.meridiem.converter.UserConverter;
import com.post.meridiem.mapper.PasswordEncodingMapper;
import com.post.meridiem.model.AuthRequest;
import com.post.meridiem.model.RestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncodingMapper passwordEncodingMapper;

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody AuthRequest authRequest) throws Exception {
        return userService.authenticateUser(userConverter.authRequestToAuthDomainRequest(authRequest));
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody RestUser restUser) {
        Optional.ofNullable(restUser)
                .map(RestUser::getPassword)
                .ifPresent(password -> restUser.setPassword(passwordEncodingMapper.toBCryptPassword(password)));
        return userService.saveUser(userConverter.restUserToDomainUser(restUser));
    }

}
