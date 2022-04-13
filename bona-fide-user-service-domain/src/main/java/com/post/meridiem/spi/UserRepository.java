package com.post.meridiem.spi;

import com.post.meridiem.model.DomainUser;

public interface UserRepository {
    String saveUser(DomainUser domainUser);
    DomainUser findUser(String email);
}
