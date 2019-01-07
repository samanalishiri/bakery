package com.saman.hexad.business.service.impl;

import com.saman.hexad.business.dto.PackDto;
import com.saman.hexad.business.repository.impl.InMemoryOrderItemRepository;
import com.saman.hexad.business.service.AbstractService;
import com.saman.hexad.business.service.IOrderItemService;
import com.saman.hexad.business.service.helper.OrderItemHelper;
import com.saman.hexad.model.OrderItem;

import java.util.List;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public class OrderItemService extends AbstractService<Integer, OrderItem, InMemoryOrderItemRepository> implements IOrderItemService {

    public static final OrderItemService INSTANCE = new OrderItemService();

    private final OrderItemHelper helper = new OrderItemHelper();

    public OrderItemService() {
        super(InMemoryOrderItemRepository.INSTANCE);
    }

    /**
     * @param item
     * @return
     */
    public List<PackDto> findMinimalNumberOfPacks(OrderItem item) {
        return helper.findMinimalNumberOfPacks(item);
    }

}
