package jmcompany.erp.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ItemInfo {

    private String itemNum;
    private String itemName;

    public ItemInfo() { }

    public ItemInfo(String itemNum, String itemName) {
        this.itemNum = itemNum;
        this.itemName = itemName;
    }
}
