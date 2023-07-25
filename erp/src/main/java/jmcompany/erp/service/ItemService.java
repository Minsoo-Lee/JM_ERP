package jmcompany.erp.service;

import jmcompany.erp.domain.Item;
import jmcompany.erp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

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
}
