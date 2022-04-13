package com.post.meridiem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RestUser {
    private String email;
    private String password;
}
