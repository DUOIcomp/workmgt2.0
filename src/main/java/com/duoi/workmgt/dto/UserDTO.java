package com.duoi.workmgt.dto;

import com.duoi.workmgt.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;


@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private String password;
    @Email
    private String email;

    private boolean activated;


    public UserDTO(){
    }

    public UserDTO(User user) {
        this.id = user.getUserId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.isActivated();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                '}';
    }
}
