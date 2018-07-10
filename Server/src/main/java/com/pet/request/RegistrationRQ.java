package com.pet.request;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode
public class RegistrationRQ {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Date birthday;
}
