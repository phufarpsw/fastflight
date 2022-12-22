package com.project_sop.userservice.query;

import lombok.Data;

@Data
public class FindPassengerById {
    private String _id;

    public FindPassengerById(String id) {
        this._id = id;
    }
}
