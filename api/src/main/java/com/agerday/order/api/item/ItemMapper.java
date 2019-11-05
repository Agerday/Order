package com.agerday.order.api.item;

import com.agerday.order.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toDomain(CreateItemDto createItemDto) {
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                (int) createItemDto.getPrice(),
                createItemDto.getAmount()

        );
    }

    public ItemDto toDto(Item item) {
        return new ItemDto()
                .withId(item.getId())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice())
                .withAmount(item.getAmount()
                );
    }
}
