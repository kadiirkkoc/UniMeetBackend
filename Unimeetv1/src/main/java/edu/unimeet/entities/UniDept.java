package edu.unimeet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "unidept")
public class UniDept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UniDeptId")
    private Integer uniDeptId;

 

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department departments;


    @ManyToOne
    @JoinColumn(name="uni_id")
    private University universities;
    

//    @OneToMany(mappedBy = "uniDept")
//    @Cascade(CascadeType.ALL)
//    private List<Department> departments;
//
//
//    @OneToMany(mappedBy = "uniDept")
//    @Cascade(CascadeType.ALL)
//    private List<University> universities;


    @OneToMany(mappedBy = "uniDept")
    @Cascade(CascadeType.ALL)
    private List<User> users;

}