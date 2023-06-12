package edu.idat.pe.evc1.evc1.dtos.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
