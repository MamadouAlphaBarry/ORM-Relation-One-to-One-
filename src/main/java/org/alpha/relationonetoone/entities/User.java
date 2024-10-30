package org.alpha.relationonetoone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    //j'indique que l'autre classe est responsable de la relation;
    //les operations associèes a l'enfant;
    //le mode de charement de donnèes
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Profile profile;

}
