package com.springboot.web.model.dto.request;

import com.springboot.web.constants.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequest {
    private String userName;

    private String password;

    private String email;

    private Role role;

}
