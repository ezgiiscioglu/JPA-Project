package org.example.jpaProje.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({@NamedQuery(name = "UserDetail.findByUsername", query = "SELECT ud FROM  UserDetail ud WHERE ud.user.username = :username"),
        @NamedQuery(name = "UserDetail.findWithAddressByUsername", query = "SELECT ud FROM  UserDetail ud LEFT JOIN FETCH ud.addresses WHERE ud.user.username = :username"),
        @NamedQuery(name = "UserDetail.findWithAdvertisementByUsername", query = "SELECT ud FROM  UserDetail ud LEFT JOIN FETCH ud.advertisements WHERE ud.user.username = :username"),
        @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM  User u"),
        @NamedQuery(name = "User.findUserInfoByUsername",
                    query = "SELECT new org.example.jpaProje.model.UserInfo(u.username,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthDate) FROM User u WHERE u.username = :username")
})
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailId;
    private String firstName;
    private String lastName;
    private Date birthDate;

    @ElementCollection
    @JoinTable(name = "userdetail_phonenumber", joinColumns = @JoinColumn(name = "userDetailId"))
    @MapKeyColumn(name = "phoneType")
    @Column(name = "phoneNumber")
    private Map<PhoneType,String> phoneNumbers = new HashMap<PhoneType, String>();

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "userdetail_address", joinColumns = @JoinColumn(name = "userDetailId"))
    private List<Address> addresses = new ArrayList<Address>();

    @OneToMany(mappedBy = "userDetail", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    //OneToMany default olarak FetchType.LAZY
    private List<Advertisement> advertisements = new ArrayList<Advertisement>();

    @OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
    private User user;

    public UserDetail(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
