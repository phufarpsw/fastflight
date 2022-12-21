package com.project_sop.reserveservice.query;

import lombok.Data;

@Data
public class FindByUsername {
    private String username;

    public FindByUsername(String username) {
        this.username = username;
    }
}
