package jmcompany.erp.dto;

import jmcompany.erp.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {

    private Long id;
    private String madeBy;
    private String itemNum;
    private String itemName;
    private String unit;
    private int carryOver;
    private int realStock;
    private String remarks;

    public static ItemDto createNewForm(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setMadeBy(item.getMadeBy());
        itemDto.setItemNum(item.getItemInfo().getItemNum());
        itemDto.setItemName(item.getItemInfo().getItemName());
        itemDto.setUnit(item.getUnit());
        itemDto.setCarryOver(item.getCarryOver());
        itemDto.setRealStock(item.getRealStock());
        itemDto.setRemarks(item.getRemarks());
        return itemDto;
    }
}
