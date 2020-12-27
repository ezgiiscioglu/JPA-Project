package org.example.jpaProje.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({@NamedQuery(name = "Advertisement.findByUsername",
                    query = "SELECT a FROM  User u LEFT JOIN u.userDetail ud LEFT JOIN ud.advertisements a WHERE u.username = :username"),
        @NamedQuery(name = "Advertisement.findById",
                    query = "SELECT a FROM  Advertisement a LEFT JOIN FETCH a.educations WHERE a.advertisementId = :advertisementId"),
        @NamedQuery(name = "Advertisement.findAdvertisements", query = "SELECT a FROM Advertisement a")
})
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advertisementId;
    private String title;
    @Lob
    private String definition;
    @Lob
    private String criteria;
    private Date addDate = new Date();
    private Date updateDate;
    private boolean enabled = false;
    private Date removeDate;

    @ManyToMany
    @JoinTable(name = "advertisement_education", joinColumns = @JoinColumn(name = "advertisementId"),
            inverseJoinColumns = @JoinColumn(name = "educationId"))
    private List<Education> educations = new ArrayList<Education>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDetailId")
    private UserDetail userDetail;

    public Advertisement(String title, String definition, String criteria) {
        this.title = title;
        this.definition = definition;
        this.criteria = criteria;
    }
}
