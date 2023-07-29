package jmcompany.erp.dto;

import jmcompany.erp.domain.Sell;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellDto {

    private Long id;
    private String date;
    private String madeBy;
    private String customer;
    private String itemNum;
    private String itemName;
    private String unit;
    private int quantity;
    private int unitPrice;
    private int price;
    private int vat;
    private int totalPrice;
    private String remarks;

    public static SellDto createNewForm(Sell sell) {
        SellDto sellDto = new SellDto();
        sellDto.setId(sell.getId());
        sellDto.setDate(sell.getDate());
        sellDto.setMadeBy(sell.getMadeBy());
        sellDto.setCustomer(sell.getCustomer());
        sellDto.setItemNum(sell.getItemInfo().getItemNum());
        sellDto.setItemName(sell.getItemInfo().getItemName());
        sellDto.setUnit(sell.getUnit());
        sellDto.setQuantity(sell.getQuantity());
        sellDto.setUnitPrice(sell.getUnitPrice());
        sellDto.setPrice(sell.getPrice());
        sellDto.setVat(sell.getVat());
        sellDto.setTotalPrice(sell.getTotalPrice());
        sellDto.setRemarks(sell.getRemarks());
        return sellDto;
    }
}
