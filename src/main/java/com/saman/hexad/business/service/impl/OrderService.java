package com.saman.hexad.business.service.impl;

import com.saman.hexad.business.dto.OrderDto;
import com.saman.hexad.business.dto.OrderItemDto;
import com.saman.hexad.business.repository.impl.InMemoryOrderRepository;
import com.saman.hexad.business.service.AbstractService;
import com.saman.hexad.business.service.IOrderService;
import com.saman.hexad.model.Order;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */
public class OrderService extends AbstractService<Integer, Order, InMemoryOrderRepository> implements IOrderService {

    public static final OrderService INSTANCE = new OrderService();

    protected OrderService() {
        super(InMemoryOrderRepository.INSTANCE);
    }

    /**
     * @param order
     * @return
     */
    public OrderDto calculate(Order order) {
        OrderDto orderDto = new OrderDto();
        order.getItems().stream()
                .forEach(item -> {
                    orderDto.addItem(new OrderItemDto(item, OrderItemService.INSTANCE.findMinimalNumberOfPacks(item)));
                });

        return orderDto;
    }
}
