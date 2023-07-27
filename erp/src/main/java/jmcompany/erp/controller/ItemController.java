package jmcompany.erp.controller;

import jmcompany.erp.domain.Item;
import jmcompany.erp.dto.ItemDto;
import jmcompany.erp.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public String getItemList(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "item/itemList";
    }

    @GetMapping("/new")
    public String createItemForm(Model model) {
        model.addAttribute("form", new ItemDto());
        return "item/createItemForm";
    }

    @PostMapping("/new")
    public String create(ItemDto form) {
        Item item = Item.createNewItem(form);
        itemService.join(item);
        return "redirect:/item";
    }

    @GetMapping("/{id}/edit")
    public String updateItemForm(@PathVariable("id") Long id, Model model) {
        Item item = itemService.findOne(id);
        ItemDto form = ItemDto.createNewForm(item);
        model.addAttribute("form", form);
        return "item/updateItemForm";
    }

    @PostMapping("/{id}/edit")
    public String updateItemForm(@PathVariable("id") Long id, ItemDto form) {
        itemService.update(form);
        return "redirect:/item";
    }
}
