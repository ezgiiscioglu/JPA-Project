package org.example.jpaProje.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({@NamedQuery(name = "User.findById", query = "SELECT u FROM  User u LEFT JOIN FETCH u.userDetail WHERE u.userId = :userId"),
               @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM  User u WHERE u.username = :username"),
               @NamedQuery(name = "User.findWithUserDetailByUsername",
                           query = "SELECT u FROM  User u LEFT JOIN FETCH u.userDetail WHERE u.username = :username"),
               @NamedQuery(name = "User.findUsers", query = "SELECT u FROM  User u"),
               @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM  User u"),
               @NamedQuery(name = "User.findUserInfoByUsername",
                           query = "SELECT new org.example.jpaProje.model.UserInfo(u.username,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthDate) FROM User u WHERE u.username = :username"),
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private UserDetail userDetail;

    public User(String username, String password, Date creationDate) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }
}
