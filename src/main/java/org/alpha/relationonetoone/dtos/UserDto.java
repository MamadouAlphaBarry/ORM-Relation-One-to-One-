package org.alpha.relationonetoone.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.alpha.relationonetoone.entities.Profile;
import org.hibernate.envers.Audited;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
