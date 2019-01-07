package com.saman.hexad.business.dto;

import com.saman.hexad.model.OrderItem;
import com.saman.hexad.business.service.helper.PackHelper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public final class OrderItemDto {

    private final int quantity;
    private final String code;
    private final List<PackDto> packs;
    private final BigDecimal sum;

    public OrderItemDto(OrderItem item, List<PackDto> packs) {
        this.quantity = item.getQuantity();
        this.code = item.getProduct().getCode();
        this.packs = packs;
        this.sum = PackHelper.calculateTotalPrice(packs);
    }


    @Override
    public String toString() {
        return quantity + " " + code + " " + sum + " " + Arrays.toString(packs.toArray());
    }
}
