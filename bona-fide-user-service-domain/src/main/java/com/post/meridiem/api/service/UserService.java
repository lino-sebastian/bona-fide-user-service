package com.post.meridiem.api.service;

import com.post.meridiem.model.AuthDomainRequest;
import com.post.meridiem.model.DomainUser;

public interface UserService {
    String saveUser(DomainUser domainUser);
    String authenticateUser(AuthDomainRequest authDomainRequest) throws Exception;
}
