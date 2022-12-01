package edu.unimeet.entities;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeptID")
    private Integer deptId;


    @Column(name = "DeptName")
    private String deptName;


    @OneToMany(mappedBy = "departments")
    @Cascade(CascadeType.ALL)
    private List<UniDept> uniDept;

}