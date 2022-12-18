package com.project_sop.userservice.query;

import lombok.Data;

@Data
public class FindUserByUsername {
    private String username;
    public FindUserByUsername(String username){
        this.username = username;
    }
}
