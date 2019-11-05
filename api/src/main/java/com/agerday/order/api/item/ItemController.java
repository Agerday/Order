package com.agerday.order.api.item;

import com.agerday.order.domain.item.Item;
import com.agerday.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private ItemService itemService;
    private ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody CreateItemDto createItemDto) {
        if (!isValidItem(createItemDto)) {
            throw new IllegalArgumentException("Missing field");
        }
        Item createdItem = itemService.addItem(itemMapper.toDomain(createItemDto));
        return itemMapper.toDto(createdItem);
    }


    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems()
                .stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean isValidItem(CreateItemDto createItemDto) {
        return (createItemDto.getName() != null
                && createItemDto.getDescription() != null
                && createItemDto.getPrice() != 0);
    }
}
