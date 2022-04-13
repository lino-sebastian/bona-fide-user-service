package com.post.meridiem.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncodingMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String toBCryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
