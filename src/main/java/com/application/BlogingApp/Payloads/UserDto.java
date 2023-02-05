package com.application.BlogingApp.Payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotEmpty
    private String name;
    @Email(message="Email address not valid")
    private String email;
    @NotEmpty
    @Size(min = 5,message = "Password must be minimum of 5 character")
    private String password;
    @NotEmpty
    private String about;
}
