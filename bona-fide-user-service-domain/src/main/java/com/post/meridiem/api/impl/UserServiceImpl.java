package com.post.meridiem.api.impl;

import com.post.meridiem.EntryPoint;
import com.post.meridiem.api.service.UserService;
import com.post.meridiem.model.AuthDomainRequest;
import com.post.meridiem.model.DomainUser;
import com.post.meridiem.spi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntryPoint entryPoint;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(DomainUser domainUser) {
        return userRepository.saveUser(domainUser);
    }

    @Override
    public String authenticateUser(AuthDomainRequest authDomainRequest) throws Exception {
        return entryPoint.authenticate(authDomainRequest.getEmail(), authDomainRequest.getPassword());
    }
}
