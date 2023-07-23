package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Stocks {

    @Id @GeneratedValue
    @Column(name = "STOCK_ID")
    private Long id;

    private int buy;
    private int sell;
    @Column(name = "STOCK_AMOUNT")
    private int stockAmount;

    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Items items;
}
