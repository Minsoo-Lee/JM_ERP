package jmcompany.erp.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Embeddable
@Getter
public class ItemInfo {
    private String item_num;
    private String item_name;
}
