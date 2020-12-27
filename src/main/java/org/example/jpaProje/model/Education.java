package org.example.jpaProje.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jpaProje.model.Advertisement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({@NamedQuery(name = "Education.findEducations", query = "SELECT e FROM  Education e"),
        @NamedQuery(name = "Education.findById", query = "SELECT e FROM  Education e WHERE e.educationId = :educationId"),
        @NamedQuery(name = "Education.findWithAdvertisement",
                    query = "SELECT e FROM  Education e LEFT JOIN FETCH e.advertisements WHERE e.educationId = :educationId")
})
public class Education implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationId;
    private String educationName;
    private int licenseYear;

    @ManyToMany(mappedBy = "educations")
    //ManyToMany default olarak FetchType.LAZY
    private List<Advertisement> advertisements = new ArrayList<Advertisement>();

    public Education(String educationName, int licenseYear) {
        this.educationName = educationName;
        this.licenseYear = licenseYear;
    }
}
