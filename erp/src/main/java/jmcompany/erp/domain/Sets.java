package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Sets {

    @Id @GeneratedValue
    @Column(name = "SET_ID")
    private Long id;

    @Column(name = "SET_NAME")
    private String setName;

    @OneToMany(mappedBy = "sets")
    private List<Parts> parts;
}
