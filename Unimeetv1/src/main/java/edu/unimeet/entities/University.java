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
@Table(name = "tb_University")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UniID")
    private Integer uniId;

    @Column(name = "UniName")
    private String uniName;

    @OneToMany(mappedBy = "universities")
    @Cascade(CascadeType.ALL)
    private List<UniDept> uniDept;

}