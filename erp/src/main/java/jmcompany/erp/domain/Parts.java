package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Parts {

    @Id @GeneratedValue
    @Column(name = "PART_ID")
    private Long id;

    @Embedded
    private ItemInfo itemInfo;
    private int stock;
    @Column(name = "PART_SET")
    private int partSet;
    @Column(name = "CAN_SET")
    private int canSet;
    @Column(name = "FINAL_PART")
    private int finalPart;
    private int spare;
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SET_ID")
    private Sets sets;


}
