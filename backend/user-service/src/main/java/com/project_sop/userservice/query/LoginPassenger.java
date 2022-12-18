package com.project_sop.userservice.query;

import lombok.Data;

@Data
public class LoginPassenger {
    private String username;
    private String password;

    public LoginPassenger(String username, String password){
        this.username = username;
        this.password = password;
    }
}
