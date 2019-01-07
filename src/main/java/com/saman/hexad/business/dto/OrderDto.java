package com.saman.hexad.business.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */
public class OrderDto {

    private final List<OrderItemDto> items = new ArrayList<>();

    /**
     * @param item
     */
    public void addItem(OrderItemDto item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return String.join("\n", items.stream().map(OrderItemDto::toString).collect(Collectors.toList()));
    }
}
