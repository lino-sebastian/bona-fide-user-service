package com.post.meridiem.repository;

import com.post.meridiem.converter.UserConverter;
import com.post.meridiem.model.DomainUser;
import com.post.meridiem.repo.JPAUserRepo;
import com.post.meridiem.spi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JPAUserRepo jpaUserRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public String saveUser(DomainUser domainUser) {
        /* TODO Implement User Validation */
        if (isNull(domainUser.getEmail())) {
            throw new IllegalArgumentException("Invalid User");
        }
        jpaUserRepo.save(userConverter.domainUserToDBUser(domainUser));
        return "User Saved";
    }

    @Override
    public DomainUser findUser(String email) {
        return userConverter.dbUserToDomainUser(jpaUserRepo.findByEmail(email));
    }
}
