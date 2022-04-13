package com.post.meridiem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class DomainUser {
    private String email;
    private String password;
}
