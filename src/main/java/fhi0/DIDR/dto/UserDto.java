package fhi0.DIDR.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UserDto {

    private long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String userType;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
