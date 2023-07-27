package jmcompany.erp.service;

import jmcompany.erp.domain.Item;
import jmcompany.erp.dto.ItemDto;
import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long join(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional
    public void update(ItemDto form) {
        Item item = itemRepository.findOne(form.getId());
        item.setMadeBy(form.getMadeBy());
        item.setItemInfo(new ItemInfo(form.getItemNum(), form.getItemName()));
        item.setUnit(form.getUnit());
        item.setCarryOver(form.getCarryOver());
        item.setRealStock(form.getRealStock());
        item.setRemarks(form.getRemarks());
    }
}
