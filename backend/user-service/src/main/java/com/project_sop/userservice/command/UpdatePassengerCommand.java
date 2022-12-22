package com.project_sop.userservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class UpdatePassengerCommand {
    @TargetAggregateIdentifier
    private String _id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String email;
    private String tel;
}
