package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;


@Getter
@Setter
public class UserDTO {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private boolean activated;


    public UserDTO(){
    }

    public UserDTO(User user) {
        this.id = user.getUserId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.getActivated();
    }
}
