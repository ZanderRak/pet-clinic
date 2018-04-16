package com.pet.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode
@Builder
@Getter
public class ClientRS {
    @NotNull
    private String uri;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String phone;
    @NotNull
    private String email;
    private Date birthday;
}
