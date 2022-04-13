package com.post.meridiem.converter;

import com.post.meridiem.model.AuthDomainRequest;
import com.post.meridiem.model.AuthRequest;
import com.post.meridiem.model.DBUser;
import com.post.meridiem.model.DomainUser;
import com.post.meridiem.model.RestUser;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class UserConverter {

    public AuthDomainRequest authRequestToAuthDomainRequest(AuthRequest authRequest) {
        AuthDomainRequest.AuthDomainRequestBuilder authDomainRequestBuilder = AuthDomainRequest.builder();
        ofNullable(authRequest).map(AuthRequest::getEmail).ifPresent(authDomainRequestBuilder::email);
        ofNullable(authRequest).map(AuthRequest::getPassword).ifPresent(authDomainRequestBuilder::password);
        return authDomainRequestBuilder.build();
    }

    public DBUser domainUserToDBUser(DomainUser domainUser) {
        DBUser.DBUserBuilder dbUserBuilder = DBUser.builder();
        ofNullable(domainUser).map(DomainUser::getEmail).ifPresent(dbUserBuilder::email);
        ofNullable(domainUser).map(DomainUser::getPassword).ifPresent(dbUserBuilder::password);
        return dbUserBuilder.build();
    }

    public DomainUser restUserToDomainUser(RestUser restUser) {
        DomainUser.DomainUserBuilder domainUserBuilder = DomainUser.builder();
        ofNullable(restUser).map(RestUser::getEmail).ifPresent(domainUserBuilder::email);
        ofNullable(restUser).map(RestUser::getPassword).ifPresent(domainUserBuilder::password);
        return domainUserBuilder.build();
    }

    public DomainUser dbUserToDomainUser(DBUser dbUser) {
        DomainUser.DomainUserBuilder domainUserBuilder = DomainUser.builder();
        ofNullable(dbUser).map(DBUser::getEmail).ifPresent(domainUserBuilder::email);
        ofNullable(dbUser).map(DBUser::getPassword).ifPresent(domainUserBuilder::password);
        return domainUserBuilder.build();
    }

}
