package com.project_sop.reserveservice.query;

import lombok.Data;

@Data
public class FindOnlyOne {
    private String username;
    private String airlineID;
    public FindOnlyOne(String username, String airlineID){
        this.username = username;
        this.airlineID = airlineID;
    }
}
